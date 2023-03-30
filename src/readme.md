# 物件導向課程內容
### 一、實體/實例 instance
+ 類別與物件的關係
1. 類別像設計圖，物件是依照設計圖出來的產物
2. 類別到物件的過程叫實體化，所以物件有常說是實體
### 二、欄位/屬性 field
### 三、靜態 static
### 四、方法/函數 method
+ 參數、可變參數
+ 內外相同變數名稱的存取
1. 類別變數/靜態變數
2. 實體變數/成員變數
3. 方法變數
4. 區塊變數
### 五、修飾子 modifier
+ public protected 空 private
### 六、包關鍵字 package keyword
+ 唯一
### 七、import keyword
1. 同包不用 import
2. import *
3. import static
### 八、建構子 constructor
+ 預設建構子
+ this/super
+ 靜態塊 static block
+ 塊 block
### 九、類別 class
+ 兄弟類別 
+ 內部類別 inner class
+ 靜態類別 static class
+ 匿名類別 anonymous class
+ 方法類別 method class
+ record 類別(java 16)
+ sealed 類別(java 17)
> 查看 class 檔名
+ 內外相同變數名稱的存取
1. 由內而外
2. 類別名稱.this
+ 類別陣列
### 十、抽象 abstract
+ 類別
+ 方法/函數
### 十一、介面 interface
+ JAVA 8
1. static
2. default
### 十二、final
### 十三、封裝 encapsulation
+ setter/getter
### 十四、繼承 inherit
+ 繼承 extends
+ 實作 implements
+ 多繼承
+ 重載 overloading
1. 方法名稱一樣，參數不同，但不管回傳值
+ 覆寫 overriding
1. 方法名稱、參數、回傳值都要一樣，但回傳值可以是子類別，參數不能是子類別
2. 如果有 throws 都可以不寫，如果要寫只能是 throws 的子類別或一樣
### 十五、多型 polymorphism
+ instanceof JDK16
### 十六、Java API
### 十七、Wrapper
1. 基本型態陣列
2. call by value 和 call by address
3. call by reference
4. Integer = 1 和 Integer i = new Integer(1) 的區別
### 十八、Object 類別
### 十九、例外 exception
### 二十、枚舉類別 enum
### 二十一、泛型 generic
### 二十二、Annotation
### 二十三、反射 reflection
### 二十四、lambda
+ () -> {}
### 二十五、method reference
+ Object::method
### 二十六、Stream
+ 水龍頭
+ 中間操作、終止操作
