#include "jitbuilder_release_java_samples_Simple.h"
#include <iostream>

JNIEXPORT void JNICALL Java_jitbuilder_release_java_samples_Simple_test
  (JNIEnv *, jclass) {
      std::cout << "Main working\n";
  }