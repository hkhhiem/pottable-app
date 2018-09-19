#include <jni.h>
#include <string>
#include <math.h>
/*
fuck name mangling
extern "C" {

IN ORDER FOR C++ FUNCTIONS TO BE VISIBLE TO JAVA CLASSES:
They must have a Java_ prefix.
They must contain a mangled form of the package name where the dots are replaced with underscores.
They must contain the name of the Java class they belong to.
    JNIEXPORT jstring JNICALL //specifies visibility
    Java_com_tpp_pottable_

}

*/