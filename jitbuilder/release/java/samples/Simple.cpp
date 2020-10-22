#include "Simple.h"
#include <iostream>

JNIEXPORT void JNICALL Java_Simple_test
  (JNIEnv *, jclass) {
      std::cout << "Main working\n";
  }