def is = new File("input0.txt").newInputStream()
def lines = is.readLines()
lines.each (line -> {
    println line
})
is.close()
