-dontshrink
-dontoptimize
-dontwarn

# Keep Bukkit/Paper Plugin
-keep public class * extends org.bukkit.plugin.java.JavaPlugin {
    public *;
}

# Keep Bukkit Event Handlers
-keepclassmembers class * {
    @org.bukkit.event.EventHandler public *;
}

# Keep unnamed inject / javax.inject
-keepclassmembers class * {
    @javax.inject.Inject <fields>;
    @javax.inject.Inject <methods>;
    @team.unnamed.inject.InjectAll <fields>;
    @team.unnamed.inject.InjectAll <methods>;
}
-keep class * extends team.unnamed.inject.AbstractModule {
    *;
}

# Keep Triumph Commands
-keep @dev.triumphteam.cmd.core.annotation.* class * {
    public *;
}
-keepclassmembers class * {
    @dev.triumphteam.cmd.core.annotation.* public *;
}

# Keep attributes
-keepattributes Exceptions,InnerClasses,Signature,Deprecated,SourceFile,LineNumberTable,*Annotation*,EnclosingMethod
