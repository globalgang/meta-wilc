# meta-wilc #

# Yocto Setup for AT91SAM Serise #
linux4sam Link : https://github.com/linux4sam/meta-atmel

*4월 09일 Kernel 폴더 변경 : linux-yocto-cutom -> linux-at91  
*4월 13일 DISTRO = "poky" 로 빌드시 qt 화면 출력되지 않음.

### Folder Tree ###

>**meta-(name)**  
>>**recipes-(recipes name)**
>>>module-name.bb  
>>>module-name.bbappend  
>>>**files-(additional folder)**
>>>>additional_file

### File ###
1. BB  
	>새로운 모듈 추가 혹은 기존 모듈의 업그레이드 버전 제공  
	>새로운 폴더 혹은 기존 폴더 트리를 활용하되 다른 모듈과 이름이 중복되지 않도록 설정  
	>패키지명을 필히 작성해야하며, 빌드시 해당 명칭을 확인하여 빌드 진행  
	>웹에서 다운로드하거나 파일을 구비하여 컴파일후 복사 혹은 펌웨어 같은 경우 바로 복사  
	
2. BBAPPEND
	>기존 모듈 편집  
	>기존에 포함된 모듈과 동등한 위치에 있어야하고, 수정하고자 하는 모듈의 파일명과 동일해야함.  
	>모듈의 편집이기 때문에 "수정될 사항을 기입"하면 됨.  
	>파일 패치 혹은 빌드 옵션 변경  
	
3. Additional File
	>추가되는 파일 혹은 패치 사항

### Build ###
1. bb / bbappend parsing
2. download or fetch source from web  
3. checksum
4. patch(***use bbappend***)  
5. configuration(***use conf***)
6. compile (make module)
7. generate rpm / deb / ipk
8. make image

### Parsing ###
- (build_dir)/conf/**bblayer.conf**  
~~~~
BBLAYERS ?= " \
  ...
+  ${BSPDIR}/meta-wilc \
~~~~

### Configuration ###
- (build_dir)/conf/**local.conf**  
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


# BB & BBAPPEND #
1. BB
  - 새로운 모듈 추가
  - 새로운 폴더 혹은 기존 폴더 트리를 활용하되 다른 모듈과 이름이 중복되지 않도록 설정
  - 패키지명을 필히 작성해야하며, 빌드시 해당 명칭을 확인하여 빌드 진행
  - 웹에서 다운로드하거나 파일을 구비하여 컴파일후 복사 혹은 펌웨어 같은 경우 바로 복사
2. BBAPPEND
  - 기존 모듈 편집
  - 기존에 포함된 모듈과 동등한 위치에 있어야하고, 수정하고자 하는 모듈의 파일명과 동일해야함.
  - 모듈의 편집이기 때문에 "수정될 사항을 기입"하면 됨.
  - 파일 패치 혹은 빌드 옵션 변경

# 빌드 환경 설정 #
1. local.conf
  - 빌드시 사용되는 옵션 / 모듈 등을 추가 혹은 편집
2. bblayer.conf
  - 빌드시 사용될 폴더(meta 폴더)를 추가 혹은 편집

# Poky Build Error Fix #
1. Network Fail
  - edit /meta-yocto/conf/distro/poky.conf
  - CONNECTIVITY_CHECK_URIS = ""
2. Library
  - build-essential
  - device-tree-compiler
  - lzma
  - lzop
  - u-boot-tools
  - libncurses5-dev:amd64 
  - diffstat
  - gawk
  - chrpath
  - libsdl1.2-dev
  - pandoc
  - texinfo

# add WILC1000 #
3. local.conf
  - IMAGE_INSTALL_append += " \
  - hostapd \
  - linux-firmware-atmel-wilc1000 \ 
  - wilc1000 \
  - wilc1000-demo-init"
