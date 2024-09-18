//
// Created by 111 on 2024/09/18.
//
#include <jni.h>
#include <string>
extern "C" {
#include "libavcodec/avcodec.h"
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_neway_ffmpegndk_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_neway_ffmpegndk_MainActivity_getConfiguration(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF(avcodec_configuration());
}