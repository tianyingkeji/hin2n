//
// Created by 111 on 2024/09/27.
//
#include <jni.h>
#include <string>
extern "C" {
#include "libavcodec/avcodec.h"
}

extern "C"
JNIEXPORT jstring JNICALL
Java_wang_switchy_hin2n_activity_CameraControlActivity_stringFromJNI(JNIEnv *env, jobject thiz) {
    // TODO: implement stringFromJNI()
    return env->NewStringUTF("ssssss");
}
extern "C"
JNIEXPORT jstring JNICALL
Java_wang_switchy_hin2n_activity_CameraControlActivity_getConfiguration(JNIEnv *env, jobject thiz) {
    // TODO: implement getConfiguration()
    return env->NewStringUTF(avcodec_configuration());
}