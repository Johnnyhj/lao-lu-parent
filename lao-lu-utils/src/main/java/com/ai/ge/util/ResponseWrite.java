package com.ai.ge.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class ResponseWrite {
	 public static void Write(HttpServletResponse response, String s)
	    {
	        PrintWriter write = null;
	        try
	        {
	            response.setHeader("Cache-Control", "no-cache");
	            response.setContentType("text/plain");
	            write = response.getWriter();
	            write.write(s);
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            if (null != write)
	            {
	                write.close();
				}
	        }
	    }
}
