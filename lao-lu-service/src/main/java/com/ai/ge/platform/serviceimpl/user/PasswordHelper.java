package com.ai.ge.platform.serviceimpl.user;

import com.ai.ge.platform.model.user.SysUser;
import com.ai.ge.platform.service.sys.SysDataService;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    @Resource
    private SysDataService sysDataService;

    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public void encryptPassword(SysUser user) {

        algorithmName = sysDataService.getByKeyType("password.algorithmName", SysDataService.MGR_APP, "md5");
        hashIterations = Integer.parseInt(sysDataService.getByKeyType("password.hashIterations", SysDataService.MGR_APP, "2"));


        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                hashIterations).toHex();

        user.setPassword(newPassword);
    }

    public String getEncryptPassword(String password,SysUser sysUser){

        algorithmName = sysDataService.getByKeyType("password.algorithmName", SysDataService.MGR_APP, "md5");
        hashIterations = Integer.parseInt(sysDataService.getByKeyType("password.hashIterations", SysDataService.MGR_APP, "2"));

        String newPassword = new SimpleHash(
                algorithmName,
                password,
                ByteSource.Util.bytes(sysUser.getUsername() + sysUser.getSalt()),
                hashIterations).toHex();

        return newPassword;
    }
}
