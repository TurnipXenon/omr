#include "MethodHandler.h"

JNIEXPORT jint JNICALL Java_MethodHandler_invoke
  (JNIEnv * env, jobject thisObject, jint oldValue) {
      ++oldValue;
      return oldValue;
  }