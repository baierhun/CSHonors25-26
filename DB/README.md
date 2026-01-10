### Setup

> edit config templates

* go to `Run > Edit Configurations...`
* make sure `Application` is selected
* on the bottom select `Edit configuration templates`
* select `modify options`
* `Add VM options`
* add `--enable-native-access=ALL-UNNAMED` 

> Install `java v21`

When asked, do not set it to the default
```bash
 sdk install java 21.0.9-librca
```
> check `build.gradle` for build settings

> main class should be in `org.example.main` package
