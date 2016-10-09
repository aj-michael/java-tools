package(default_visibility = ["//visibility:public"])

java_library(
    name = "dexfile",
    srcs = glob(["*.java"]),
    deps = [
        "//java/net/ajmichael/util",
        "//third_party:auto_value",
        "//third_party:guava",
    ],
)

java_binary(
    name = "dedexer",
    main_class = "net.ajmichael.dexfile.Dedexer",
    runtime_deps = [":dexfile"],
)
