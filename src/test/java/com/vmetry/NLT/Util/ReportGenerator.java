package com.vmetry.NLT.Util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.vmetry.NTL.intializer.InitializerTest;

public class ReportGenerator extends InitializerTest {

	@Test
	public static void archievefiles() throws IOException
	{
		if(isarchieve)
		{
			
		
		SimpleDateFormat df=new SimpleDateFormat("YYYY-MM-dd hh-mm-ss-mmm");
	String name=df.format(new Date());
	System.out.println(name);
		File srcdir=new File("C:\\SeleniumWorkspace\\DDDFramework\\Screenshot");
		File destDir=new File("C:\\SeleniumWorkspace\\DDDFramework\\archievedfile\\"+"old_"+name);
		FileUtils.copyDirectory(srcdir, destDir);
		FileUtils.cleanDirectory(srcdir);
		isarchieve=false;
		
	}
}
}
