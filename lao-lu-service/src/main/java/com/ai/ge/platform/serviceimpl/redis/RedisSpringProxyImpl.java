package com.ai.ge.platform.serviceimpl.redis;

import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.pay.weixin.wxpay.utils.JackJson;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.Map.Entry;

/**
 * spring 代理jedis客户端功能与redis server通信, 依赖spring-data-redis-1.0.2.jar包.
 */
@Service("redisSpringProxy")
public class RedisSpringProxyImpl implements RedisSpringProxy {

    private static final Logger logger = LoggerFactory.getLogger(RedisSpringProxyImpl.class);

    @Resource(name = "redisTemplate")
    RedisTemplate<Serializable, Serializable> redisTemplate;

    @Resource(name = "redisTemplate01")
    RedisTemplate<Serializable, Serializable> redisTemplate01;


    /**
     * 将指定的value 与此映射中的指定key 关联, 保存到redis 中
     */
    public void save(final String key, final Object value) {
        try {
            redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection)
                        throws DataAccessException {
                    connection.select(hashRedisDB(key));
                    connection.set(serializeKey(key), serializeValue(value));
                    return null;
                }
            });
        } catch (Exception e) {
            logger.error(e.getMessage());
        }


    }

    /**
     * 将指定的value 与此映射中的指定key 关联, 保存到redis 中
     *
     * @param expireTime 指定秒单位过期时间
     */
    public void saveEx(final String key, final long expireTime, final Object value) {
        try {
            redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection)
                        throws DataAccessException {
                    connection.select(hashRedisDB(key));
                    connection.setEx(serializeKey(key), expireTime, serializeValue(value));
                    return null;
                }
            });
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Redis的Set是string类型的无序集合。集合成员是唯一的，这就意味着集合中不能出现重复的数据。
     * Redis 中 集合是通过哈希表实现的，所以添加，删除，查找的复杂度都是O(1)。
     * 集合中最大的成员数为 232 - 1 (4294967295, 每个集合可存储40多亿个成员)。
     * @param key
     * @param value
     */
    public void sAdd(final String key, final Object... value){
        try {
            redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection)
                        throws DataAccessException {
                    connection.select(hashRedisDB(key));
                    connection.sAdd(serializeKey(key),serializeValue(value));
                    return null;
                }
            });
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Redis Srem 命令用于移除集合中的一个或多个成员元素，不存在的成员元素会被忽略。
     * 当 key 不是集合类型，返回一个错误。
     * @param key
     * @param value
     */
    public void sRem(final String key, final Object... value){
        try {
            redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection)
                        throws DataAccessException {
                    connection.select(hashRedisDB(key));
                    connection.sRem(serializeKey(key), serializeValue(value));
                    return null;
                }
            });
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Redis Scard 命令返回集合中元素的数量。
     * 集合的数量。 当集合 key 不存在时，返回 0 。
     * @param key
     * @return
     */
    public Long sCard(final String key){
        try {
            return redisTemplate.execute(new RedisCallback<Long>() {
                @Override
                public Long doInRedis(RedisConnection connection)
                        throws DataAccessException {
                    connection.select(hashRedisDB(key));
                    return connection.sCard(serializeKey(key));
                }
            });
        } catch (Exception e) {
            logger.error(e.getMessage());
            return 0l;
        }
    }
    /**
     * 只提供集合 key 参数时，返回一个元素；如果集合为空，返回 nil 。
     * 如果提供了 count 参数，那么返回一个数组；如果集合为空，返回空数组。
     * @param key
     * @param number
     * @param clazz
     * @param elementClasses
     * @return
     */
    public List sRandMember(final String key, final Long number, final Class clazz, final Class... elementClasses){

        try {
            return redisTemplate.execute(new RedisCallback<List>() {
                @Override
                public  List doInRedis(RedisConnection connection)
                        throws DataAccessException {
                    connection.select(hashRedisDB(key));
                    List<byte[]>  list = connection.sRandMember(serializeKey(key), number);
                    List result = new ArrayList();
                    if(null == list || list.size() == 0){
                        return result;
                    }else{
                        for(byte[] b : list){
                            result.add(deserializeValue(b, clazz, elementClasses));
                        }
                        return result;
                    }
                }
            });
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ArrayList<T>();
        }
    }

    /**
     * 返回指定key 所映射的值. 如果redis 中不包含该key 的映射关系，则返回 null
     */
    public <T> T read(final String key, final Class<T> clazz, final Class... elementClasses) {
        try {
            return redisTemplate.execute(new RedisCallback<T>() {
                @Override
                public T doInRedis(RedisConnection connection)
                        throws DataAccessException {
                    byte[] keyBytes = serializeKey(key);
                    connection.select(hashRedisDB(key));
                    if (connection.exists(keyBytes)) {
                        byte[] valueBytes = connection.get(keyBytes);
                        return deserializeValue(valueBytes, clazz, elementClasses);
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }


    /**
     * 如果存在一个key 的映射关系，则将其从redis 中移除
     *
     * @return 被删除 key 的数量
     */
    public Long delete(final String key) {
        try {
            return redisTemplate.execute(new RedisCallback<Long>() {
                @Override
                public Long doInRedis(RedisConnection connection) {
                    connection.select(hashRedisDB(key));
                    return connection.del(serializeKey(key));
                }
            });
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * <p>将哈希表 key 中的域 field(map键) 的值设为 value</p>
     * <p>如果 key 不存在，一个新的哈希表被创建并进行 HSET 操作</p>
     * <p>如果域 field 已经存在于哈希表中，旧值将被覆盖</p>
     *
     * @param key   redis哈希表 key
     * @param field 与指定值关联的field(map键)
     * @param value 与指定field(map键)关联的值
     * @return 如果 field 是哈希表中的一个新建域，并且值设置成功, 返回 true, <br>如果哈希表中域 field(map键) 已经存在且旧值已被新值覆盖，返回false ,
     * 操作失败返回null 。
     */
    public Boolean hSet(final String key, final Object field, final Object value) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.select(hashRedisDB(key));
                return connection.hSet(serializeKey(key), serializeValue(field), serializeValue(value));
            }
        });
    }

    /**
     * 返回redis哈希表 key 中给定域 field(map键) 的值
     *
     * @param key   redis哈希表 key
     * @param field 与指定值关联的field(map键)
     * @return 返回指定 key 和指定 field(map键) 所映射的值,当给定 field(map键) 不存在或是给定 key 不存在时，返回 nil 。
     */
    public <T> T hGet(final String key, final Object field, final Class<T> clazz, final Class... elementClasses) {
        return redisTemplate01.execute(new RedisCallback<T>() {
            @Override
            public T doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.select(hashRedisDB(key));
                byte[] value = connection.hGet(serializeKey(key), serializeValue(field));
                return deserializeValue(value, clazz, elementClasses);
            }

        });
    }

    /**
     * redis 存储 map
     *
     * @param key       redis哈希表 key
     * @param mapObject map对象
     */
    public void hmSet(final String key, final Map<Object, Object> mapObject) {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {

                Map<byte[], byte[]> mapByte = new HashMap<byte[], byte[]>(mapObject.size());

                for (final Entry<Object, Object> entry : mapObject.entrySet()) {
                    byte[] mapKey = serializeValue(entry.getKey());
                    byte[] mapValue = serializeValue(entry.getValue());
                    mapByte.put(mapKey, mapValue);
                }
                connection.select(hashRedisDB(key));
                connection.hMSet(serializeKey(key), mapByte);

                mapByte = null;// release

                return null;
            }

        });
    }


    /**
     * 从reids中删除哈希表 key 中, 一个给定域
     *
     * @param key   redis哈希表 key
     * @param field 与指定值关联的field
     * @return true或false
     */
    public Boolean hDel(final String key, final String field) {
        return (Boolean) redisTemplate.execute(new RedisCallback<Object>() {

            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.select(hashRedisDB(key));
                return connection.hDel(serializeKey(key), serializeValue(field));
            }

        });
    }

    /**
     * 返回哈希表 key 中域的数量.
     *
     * @param key
     * @return 哈希表中域的数量, 当 key 不存在时,返回 0.
     */
    public Long hLen(final String key) {

        return (Long) redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.select(hashRedisDB(key));
                return connection.hLen(serializeKey(key));
            }

        });
    }

    /**
     * 返回哈希表 key 中的所有域.
     *
     * @param key
     * @return 一个包含哈希表中所有域的表, 当 key 不存在时,返回一个空。
     */
    public Set<String> hKeys(final String key) {
        return redisTemplate.execute(new RedisCallback<Set<String>>() {

            @Override
            public Set<String> doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.select(hashRedisDB(key));
                Set<byte[]> field = connection.hKeys(serializeKey(key));
                if (null != field && field.size() > 0) {
                    Set<String> ret = new TreeSet<String>();
                    for (byte[] bs : field) {
                        ret.add(deserializeValue(bs, String.class));
                    }
                    return ret;
                }
                return null;
            }

        });
    }

    /**
     * 以<code>List</code> 数据结构存储到redis 中, 允许添加重复值
     *
     * @param key    redis哈希表 key
     * @param values 存储一个值或多个值
     * @return 返回列表长度
     */
    public Long lPush(final String key, final Object... values) {
        return (Long) redisTemplate.execute(new RedisCallback<Object>() {

            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.select(hashRedisDB(key));
                Long count = new Long(0);
                byte[] keyByte = serializeKey(key);
                for (Object value : values) {
                    byte[] val = serializeValue(value);
                    count = connection.lPush(keyByte, val);
                }
                return count;
            }

        });
    }

    /**
     * 以<code>List</code> 数据结构存储到redis 中, 允许添加重复值
     *
     * @param key    redis哈希表 key
     * @param values 存储一个值或多个值
     * @return 返回列表长度
     */
    @Override
    public Long rPush(final String key, final Object... values) {
        return (Long) redisTemplate.execute(new RedisCallback<Object>() {

            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.select(hashRedisDB(key));
                Long count = new Long(0);
                byte[] keyByte = serializeKey(key);
                for (Object value : values) {
                    byte[] val = serializeValue(value);
                    count = connection.rPush(keyByte, val);
                }
                return count;
            }

        });
    }

    /**
     * 移除并返回列表 key 的头元素
     *
     * @param key redis list key
     * @return value
     */
    public <T> T lPop(final String key, final Class<T> clazz, final Class... elementClasses) {
        return redisTemplate.execute(new RedisCallback<T>() {

            public T doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.select(hashRedisDB(key));
                byte[] value = connection.lPop(serializeKey(key));
                return deserializeValue(value, clazz, elementClasses);
            }

        });
    }

    /**
     * 移除并返回列表 key 的尾元素
     *
     * @param key redis list key
     * @return value
     */
    public <T> T rPop(final String key, final Class<T> clazz, final Class... elementClasses) {
        return redisTemplate.execute(new RedisCallback<T>() {
            public T doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.select(hashRedisDB(key));
                byte[] value = connection.rPop(serializeKey(key));
                return deserializeValue(value, clazz, elementClasses);
            }
        });
    }

    @Override
    public void flushAll() {
        redisTemplate.execute(new RedisCallback<T>() {
            public T doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.flushAll();

                return null;
            }
        });
    }

    /**
     * redis缓存hash策略
     *
     * @param key
     * @return
     */
    private int hashRedisDB(String key) {
        if (null == key) {
            return 0;
        } else if (key.indexOf("_") > 0) {
            key = key.substring(0, key.indexOf("_"));
        }
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            return 0;
        }
        md.update(key.getBytes());
        StringBuffer buf = new StringBuffer();
        byte[] bits = md.digest();
        for (int i = 0; i < bits.length; i++) {
            int a = bits[i];
            if (a < 0) a += 256;
            if (a < 10) buf.append("0");
            buf.append(String.valueOf(a));
            if (i >= 2) break;
        }

        return Integer.parseInt(String.valueOf(Long.valueOf(buf.toString()).longValue() % 15)) + 1;
    }

    public RedisConnection getRedisConnection() {
        return redisTemplate.getConnectionFactory().getConnection();
    }

    protected byte[] serializeKey(final String key) {
        return redisTemplate.getStringSerializer().serialize(key);
    }

    @SuppressWarnings("unchecked")
    protected byte[] serializeValue(final Object value) {
        String json = JackJson.fromObjectToJson(value);
        return redisTemplate.getStringSerializer().serialize(json);
    }

    protected <T> T deserializeValue(final byte[] value, Class<T> clazz, Class... elementClasses) {
        String json = redisTemplate.getStringSerializer().deserialize(value);
        return JackJson.fromJsonToObject(json, clazz, elementClasses);
    }

    public RedisTemplate<Serializable, Serializable> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(
            RedisTemplate<Serializable, Serializable> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
