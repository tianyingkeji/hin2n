cmake_minimum_required(VERSION 3.10.2)
#自动生成，自己的项目名
project("ffmpegndk")

message("start............................................................")
# 1. 定义so库和头文件所在目录相对与脚本的位置的变量，方面后面使用
set(ffmpeg_lib_dir_neway ${CMAKE_SOURCE_DIR}/libs/${ANDROID_ABI})
set(ffmpeg_head_dir ${CMAKE_SOURCE_DIR}/src/main/cpp/include)

# 2. 添加头文件目录
include_directories(${ffmpeg_head_dir})

#==========================ffmpeg引入开始====================================
#add_library（配置模块so库编译信息），set_target_properties（为目标配置编译属性），对于三方so，这两个方法要成对出现
add_library( avcodec
        SHARED
        IMPORTED)
set_target_properties(
        avcodec
        PROPERTIES IMPORTED_LOCATION
        ${ffmpeg_lib_dir_neway}/libavcodec.so)

add_library( avdevice
        SHARED
        IMPORTED)
set_target_properties(
        avdevice
        PROPERTIES IMPORTED_LOCATION
        ${ffmpeg_lib_dir_neway}/libavdevice.so)

add_library( avfilter
        SHARED
        IMPORTED)
set_target_properties(
        avfilter
        PROPERTIES IMPORTED_LOCATION
        ${ffmpeg_lib_dir_neway}/libavfilter.so)

add_library( avformat
        SHARED
        IMPORTED)
set_target_properties(
        avformat
        PROPERTIES IMPORTED_LOCATION
        ${ffmpeg_lib_dir_neway}/libavformat.so)

add_library( avutil
        SHARED
        IMPORTED)
set_target_properties(
        avutil
        PROPERTIES IMPORTED_LOCATION
        ${ffmpeg_lib_dir_neway}/libavutil.so)

add_library( swresample
        SHARED
        IMPORTED)
set_target_properties(
        swresample
        PROPERTIES IMPORTED_LOCATION
        ${ffmpeg_lib_dir_neway}/libswresample.so)

add_library( swscale
        SHARED
        IMPORTED)
set_target_properties(
        swscale
        PROPERTIES IMPORTED_LOCATION
        ${ffmpeg_lib_dir_neway}/libswscale.so)
#==========================ffmpeg引入结束====================================

#对最后一个自己的so（名称可以自定义），不需要再set_target_properties。这个so最终会生成到build中。
add_library(
        ffmpegNdkCustom
        SHARED
        native-lib.cpp)

#查找代码中使用到的android系统预留（预构建）库(如log、zlib压缩库等)
find_library(
        log-lib
        log)

#指定编译最终目标库时，cmke要链接的库。
#解释：一般形式是：target_link_libraries(your-lib library1 library2 ...)
target_link_libraries(
        #指定目标库
        ffmpegNdkCustom
        #连接 FFmpeg 相关的库
        avcodec
        avdevice
        avfilter
        avformat
        avutil
        swresample
        swscale
        ${log-lib})