def is = new File("input1.txt").newInputStream()
def lines = is.readLines()
is.close()

def cardCounts = (1..lines.size()).collect(it -> 1)

lines.eachWithIndex{ String line, int i -> {
    def sanitized = line.replaceAll(/Card\s+\d+:\s+/, "")
    def numberStrs = sanitized.split(/\s+\|\s+/)

    def luckyStr = numberStrs[0]
    def actualStr = numberStrs[1]

    def luckyNums = luckyStr.split(/\s+/).collect {it.toInteger() }
    def actualNums = actualStr.split(/\s+/).collect {it.toInteger() }

    def winCount = actualNums.findAll { luckyNums.contains(it)}.size()

    if (winCount > 0) {
        ((i + 1)..(i + winCount)).each {
            cardCounts[it] += cardCounts[i]
        }
    }

    println "Card $i || $luckyStr || $actualStr\t || $winCount"
    println "Counts: $cardCounts"
}}

def result = cardCounts.sum()
println result