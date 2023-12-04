def is = new File("input1.txt").newInputStream()
def lines = is.readLines()

def result = 0

lines.each (line -> {
    def sanitized = line.replaceAll(/Card\s+\d+:\s+/, "")
    def numberStrs = sanitized.split(/\s+\|\s+/)

    def luckyStr = numberStrs[0]
    def actualStr = numberStrs[1]

    def luckyNums = luckyStr.split(/\s+/).collect {it.toInteger() }
    def actualNums = actualStr.split(/\s+/).collect {it.toInteger() }

    def containingNums = actualNums.findAll { luckyNums.contains(it)}
    def worth = containingNums.isEmpty() ? 0 : (2**(containingNums.size() - 1))
    result += worth
    println "$luckyStr || $actualStr\t || $containingNums || $worth"
})
is.close()

println result