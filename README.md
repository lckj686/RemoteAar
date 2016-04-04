# RemoteAar
android studio arr 发布到jcenter

###1、工程描述
该工程的remote-hello 这个library 最后是编译成aar 发到birary中，最后一步是添加到jcenter 审核。审核通过就可以正常依赖。

###2、对library的依赖
a) 正常的依赖是jcenter 审核过了，普通依赖的方式    

    dependencies {
    	compile fileTree(include: ['*.jar'], dir: 'libs')
    	testCompile 'junit:junit:4.12'
    	compile 'com.android.support:appcompat-v7:23.2.0'
    	compile 'com.remotearr.demo:remote-hello:1.3.0.1'
    }
</br> 
b) jcenter在没有通过时的依赖方式：
    
    repositories{
		//自己对应的bintray 库
		//https://bintray.com/bintray/jcenter 链接的右上角 可以看到自己的库
	    maven {
	    	url "http://dl.bintray.com/lckj686/maven/"
	    	}
    }
    
    dependencies {
	    compile fileTree(include: ['*.jar'], dir: 'libs')
	    testCompile 'junit:junit:4.12'
	    compile 'com.android.support:appcompat-v7:23.2.0'
	    compile 'com.remotearr.demo:remote-hello:1.3.0.1'
    }

###3、其他说明
各自moudle 的gradle 文件自己对应配置就可以了。library的配置出：上传birary  app的配置：依赖 就ok  
对应的gradle命令有：  
1. gradlew install  
2. gradlew bintrayUpload



###3、faq
对于写该demo 时遇到的困难主要是 现在的gradle 版本一直在更新，导致一些老材料里的内容跟不上了。比如该library 关联的两个插件   
apply plugin: 'com.github.dcendents.android-maven'  
apply plugin: 'com.jfrog.bintray'  
都是新版本的需要对应 指出版本号，否则就出错了    

    apply plugin: 'com.android.library'
    apply plugin: 'com.github.dcendents.android-maven'
    apply plugin: 'com.jfrog.bintray'
    
    
    buildscript {
	    repositories {
		    jcenter()
		    mavenCentral()
		    //maven {
		    //url "https://plugins.gradle.org/m2/"
		    //
		    //}
	    }

	    dependencies {
		    classpath 'com.android.tools.build:gradle:1.5.0'
		    classpath 'com.github.dcendents:android-maven-gradle-plugin:1.3'//对应gradle 2.4+ 的com.github.dcendents.android-maven plugin
		    classpath "com.jfrog.bintray.gradle:gradle-bintray-plugin:1.6"
	    }
    }

对应plugin 和版本 以及gradle 的关系可以查阅：
[https://plugins.gradle.org/plugin/com.github.dcendents.android-maven](https://plugins.gradle.org/plugin/com.github.dcendents.android-maven "版本匹配")


