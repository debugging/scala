// if, while, for, try, match, and function calls
// they return values


val filename =
  if(!args.isEmpty) args(0)
  else "default.txt"

// assignments return value () (like void in java)


val files = (new java.io.File(".")).listFiles
for (file <- files) println(file)

for (i <- 1 to 10)
for (i <- 1 until 10) // to 9
for (file <- files if file.getName.endsWith(".scala"))
for (
  file <- files
  if file.isFile
  if file.getName.endsWith(".scala")
) println(file)

// you can nest mutiple <- clauses

// bind variables inside a for loop
for {
  file <- files
  if file.getName.endsWith(".scala")
  line <- fileLines(file)
  trimmed = line.trim
  if trimmed.matches(...)
  ..
} println(trimmed)

// yield to produce new collection
for clauses yield body

// exceptions
throw new IllegalArgumentException

try {

} catch {
  case ex: FileNotFoundException => // handle ...
  case ex: IOException => //
} finally {

}

// match is like switch
val name = "...."
val m = name match {
  case "ali" => ...
  case "john" => ...
  case "adam" => ...
  case _ => "___"
}
println(m)

// scope
// can have a var with same name in nested scopes

