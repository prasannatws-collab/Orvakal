# Proguard / R8 Rules for Orvakal Application

# Keep annotations
-keepattributes *Annotation*, InnerClasses, EnclosingMethod, Signature

# Retain Parcelable / Serializable and Keep annotations
-keepclassmembers class * {
    @androidx.annotation.Keep *;
}

# Retrofit service interfaces and methods
-keepclasseswithmembers interface * {
    @retrofit2.http.* <methods>;
}

# Gson serialization models
-keepclassmembers class com.orvakal.app.data.remote.dto.** { *; }
-keepclassmembers class com.orvakal.app.domain.model.** { *; }
-keepclassmembers class com.orvakal.app.data.local.entity.** { *; }

# Room
-keep class * extends androidx.room.RoomDatabase
