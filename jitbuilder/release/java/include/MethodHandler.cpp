#include "MethodHandler.h"

JNIEXPORT jint JNICALL Java_MethodHandler_invoke
  (JNIEnv * env, jobject thisObject, jint oldValue) {
      // todo: Pass it to the Jit builder library
      ++oldValue;
      return oldValue;
  }