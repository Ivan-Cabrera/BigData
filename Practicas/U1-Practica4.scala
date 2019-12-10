def drop(minNonNulls: Int, cols: Seq[String]): DataFrame
Permalink

(Scala-specific) Returns a new DataFrame that drops rows containing less than minNonNulls non-null and non-NaN values in the specified columns.
def drop(minNonNulls: Int, cols: Array[String]): DataFrame

Returns a new DataFrame that drops rows containing less than minNonNulls non-null and non-NaN values in the specified columns.
def drop(minNonNulls: Int): DataFrame

Returns a new DataFrame that drops rows containing less than minNonNulls non-null and non-NaN values.
def drop(how: String, cols: Seq[String]): DataFrame

(Scala-specific) Returns a new DataFrame that drops rows containing null or NaN values in the specified columns.
def drop(how: String, cols: Array[String]): DataFrame

Returns a new DataFrame that drops rows containing null or NaN values in the specified columns.
def drop(cols: Seq[String]): DataFrame

(Scala-specific) Returns a new DataFrame that drops rows containing any null or NaN values in the specified columns.
def drop(cols: Array[String]): DataFrame

Returns a new DataFrame that drops rows containing any null or NaN values in the specified columns.
def drop(how: String): DataFrame

Returns a new DataFrame that drops rows containing null or NaN values.
def drop(): DataFrame

Returns a new DataFrame that drops rows containing any null or NaN values.
def fill(valueMap: Map[String, Any]): DataFrame

(Scala-specific) Returns a new DataFrame that replaces null values.
def fill(valueMap: Map[String, Any]): DataFrame

Returns a new DataFrame that replaces null values.
def fill(value: Boolean, cols: Array[String]): DataFrame

Returns a new DataFrame that replaces null values in specified boolean columns.
def fill(value: Boolean, cols: Seq[String]): DataFrame

(Scala-specific) Returns a new DataFrame that replaces null values in specified boolean columns.
def fill(value: Boolean): DataFrame

Returns a new DataFrame that replaces null values in boolean columns with value.
def fill(value: String, cols: Seq[String]): DataFrame

(Scala-specific) Returns a new DataFrame that replaces null values in specified string columns.
def fill(value: String, cols: Array[String]): DataFrame

Returns a new DataFrame that replaces null values in specified string columns.
def fill(value: Double, cols: Seq[String]): DataFrame

(Scala-specific) Returns a new DataFrame that replaces null or NaN values in specified numeric columns.
def fill(value: Long, cols: Seq[String]): DataFrame

(Scala-specific) Returns a new DataFrame that replaces null or NaN values in specified numeric columns.
def fill(value: Double, cols: Array[String]): DataFrame

Returns a new DataFrame that replaces null or NaN values in specified numeric columns.
def fill(value: Long, cols: Array[String]): DataFrame

Returns a new DataFrame that replaces null or NaN values in specified numeric columns.
def fill(value: String): DataFrame

Returns a new DataFrame that replaces null values in string columns with value.
def fill(value: Double): DataFrame

Returns a new DataFrame that replaces null or NaN values in numeric columns with value.
def fill(value: Long): DataFrame

Returns a new DataFrame that replaces null or NaN values in numeric columns with value.
def replace[T](cols: Seq[String], replacement: Map[T, T]): DataFrame

(Scala-specific) Replaces values matching keys in replacement map.
def replace[T](col: String, replacement: Map[T, T]): DataFrame

(Scala-specific) Replaces values matching keys in replacement map.
def replace[T](cols: Array[String], replacement: Map[T, T]): DataFrame

Replaces values matching keys in replacement map with the corresponding values.
def replace[T](col: String, replacement: Map[T, T]): DataFrame

Replaces values matching keys in replacement map with the corresponding values.
