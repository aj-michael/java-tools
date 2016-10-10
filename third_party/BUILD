package(default_visibility = ["//visibility:public"])

java_library(
    name = "auto_value",
    exported_plugins = [":auto_value_plugin"],
    exports = ["@com_google_auto_value_auto_value//jar"],
)

java_plugin(
    name = "auto_value_plugin",
    processor_class = "com.google.auto.value.processor.AutoValueProcessor",
    deps = ["@com_google_auto_value_auto_value//jar"],
)

java_library(
    name = "guava",
    exports = ["@com_google_guava_guava//jar"],
)
