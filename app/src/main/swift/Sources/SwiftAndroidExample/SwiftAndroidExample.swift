// The Swift Programming Language
// https://docs.swift.org/swift-book

import CJNI

// Use @_silgen_name attribute to set native name for a function called from Java
@_silgen_name("Java_com_example_swiftandroidexample_MainActivity_swiftHelloWorld")
public func MainActivity_swiftHelloWorld(
    env: UnsafeMutablePointer<JNIEnv>, activity: JavaObject
) -> JavaObject {
    let jstr = env.pointee.pointee.NewStringUTF(env, "Swift Hello World!")
    return jstr!
}
