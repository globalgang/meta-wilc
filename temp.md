# meta-wilc #

## Yocto Setup for AT91SAM Serise ##
linux4sam Link : https://github.com/linux4sam/meta-atmel
~~~~
linux4sam change log  
*4.09 Kernel Folder changed : linux-yocto-cutom -> linux-at91  
*4.13 display is black when build set DISTRO = "poky"
~~~~

### Folder Tree ###

>**meta-(name)**  
>>**recipes-(recipes name)**
>>>module-name.bb  
>>>module-name.bbappend  
>>>**files-(additional folder)**
>>>>additional_file

### File ###
1. bb file  
	>Add new Module or Change upgrade Module.  
	>do not create duplicate file name.  
	>package name is mandatory value. yocto need package name when add new module.  
	>module is downloaded from web / ftp / git / etc... or use existing additional folder.  
	
2. bbappend file  
	>Edit or Override module.  
	>It must have same folder tree about modules for edit or override.  
	>do patch or modify module. (can change bb value.)  
	
3. additional file
	>add file(script / config / etc...) or patch file.

### Build ###
1. bb / bbappend parsing
2. download or fetch source from web(***use bb***)  
3. checksum
4. patch(***use bbappend***)  
5. configuration(***use conf***)
6. compile (make module)
7. generate rpm / deb / ipk
8. make image

### Make new Module (example meta-wilc) ###
1. Create Meta directory ([meta-wilc](https://github.com/leedean/meta-wilc))
2. Create Recipe directory ([recipes-wilc](https://github.com/leedean/meta-wilc/tree/master/recipes-wilc))
3. Create Module folder ([demo](https://github.com/leedean/meta-wilc/tree/master/recipes-wilc/demo))
4. Create *.bb file  
[wilc1000-demo-init_1.0.bb](https://github.com/leedean/meta-wilc/blob/master/recipes-wilc/demo/wilc1000-demo-init_1.0.bb)
5. Create Additional patch directory ([script](https://github.com/leedean/meta-wilc/tree/master/recipes-wilc/demo/script))
6. add patch file
[wilc1000-demo-init](https://github.com/leedean/meta-wilc/blob/master/recipes-wilc/demo/script/wilc1000-demo-init)

### Override or Edit Module (example linux kernel) ###
1. Create Meta directory ([meta-wilc](https://github.com/leedean/meta-wilc))
2. Create Recipe driectory ([recipes-kernel](https://github.com/leedean/meta-wilc/tree/master/recipes-kernel))
3. Create Module folder ([linux](https://github.com/leedean/meta-wilc/tree/master/recipes-kernel/linux))
 * ***make same directory tree about edit or override module tree***
4. Create *.bbappend file ([linux-at91_3.10.bbappend](https://github.com/leedean/meta-wilc/blob/master/recipes-kernel/linux/linux-at91_3.10.bbappend))
 * example is change source revision(git commit number).  

### Edit for Parsing ###
- (build_dir)/conf/**bblayer.conf**  
~~~~
BBLAYERS ?= " \
  ...
+  ${BSPDIR}/meta-wilc \
~~~~

### Edit for Configuration ###
- (build_dir)/conf/**local.conf**  
> ***input correct package name***
~~~~  
IMAGE_INSTALL_append += " \
  hostapd \
  linux-firmware-atmel-wilc1000 \ 
  wilc1000 \
  wilc1000-demo-init"
~~~~  

- (meta dir)/conf/distro/**poky.conf**  
~~~~
CONNECTIVITY_CHECK_URIS = ""
~~~~

## Need Library ##
~~~~
build-essential  
device-tree-compiler  
lzma  
lzop  
u-boot-tools  
libncurses5-dev:amd64  
diffstat  
gawk  
chrpath  
libsdl1.2-dev  
pandoc  
texinfo  
~~~~

## Reference ##
https://www.yoctoproject.org/  
http://hyuns-study.blogspot.kr/2013/09/yocto.html
