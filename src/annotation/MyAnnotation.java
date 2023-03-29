package annotation;


import java.lang.annotation.*;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/guides/language/annotations.html
 * Return types are restricted to primitives, String, Class, enums, annotations, and arrays of the preceding types. Methods can have default values
 * <p>
 *
 * @Retention .java       .class      JVM
 * SOURCE       ✔
 * CLASS        ✔           ✔
 * RUNTIME      ✔           ✔         ✔
 * <p>
 * @Target 內容
 * ANNOTATION_TYPE
 * CONSTRUCTOR
 * FIELD
 * LOCAL_VARIABLE
 * METHOD
 * PACKAGE
 * PARAMETER
 * TYPE： 類別、介面、enum…等
 * TYPE_PARAMETER： TYPE 的<>裡
 * TYPE_USE： 宣告在各式型態
 * MODULE
 * RECORD_COMPONENT
 */
@Target(ElementType.METHOD) // 此註解可以放在哪
@Retention(RetentionPolicy.SOURCE) // 此註解何時生效
@Deprecated // 表示被標註的範圍已過時，下一版可能就會移除，IDE 會有一個刪除線
@Inherited // 是否可被繼承
public @interface MyAnnotation {
    // 如果取名為 value，那用的時候，剛好只需要用 value 這個屬性時，可以不寫 value 這個單字
    int value() default 1; // 修飾子只能是 public，不寫也一樣，回傳值的意思表示此註解的鍵值對裡的值可以放什麼

    String name();
}
