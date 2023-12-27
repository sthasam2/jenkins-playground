#!/usr/bin/env groovy

println 'Hello World'

//
// Variables and types

def x = 1
println "x $x ${x.getClass()}"

def y
println "y $y ${y.getClass()}"
y = 3
println "y $y ${y.getClass()}"

def z = 'hello'
println "z $z ${z.getClass()}"

def w = new java.util.Date()
println "w $w ${w.getClass()}"

def a  = false
println "a $a ${a.getClass()}"

def b = 'Groovy'
println "b $b ${b.getClass()}"

def c = 1.0
type = c.getClass()
println "c $c $type"

def technologies = []
technologies = ['Javascript', 'Python', 'Java']
println "technologies :\n\t $technologies ${technologies.getClass()}"

//
// Add elements to list

technologies.add('C')
println "technologies.add('C') :\n\t $technologies"

technologies << 'C++'
println "technologies << 'C++' :\n\t $technologies"

technologies.addAll(['C#', 'Ruby'])
println "technologies.addAll(['C#','Ruby']) :\n\t $technologies"

technologies.add(0, 'PHP')
println "technologies.add(0,'PHP') :\n\t $technologies"

//
// Remove elements from list

technologies.remove('Java')
println "technologies.remove('Java') :\n\t $technologies"

technologies.remove(0)
println "technologies.remove(0) :\n\t $technologies"

technologies.removeAll(['C', 'C++'])
println "technologies.removeAll(['C','C++']) :\n\t $technologies"

technologies = technologies - ['C#', 'Ruby']
println "technologies - ['C#',Ruby'] :\n\t $technologies"

//
// Access list and iteration

println "technologies[0] :\n\t ${technologies[0]}"

println "\nPrinting for each item in the list, technologies.each { println \"Technology: \$it\" }"
technologies.each { println "Technology: $it" }

println "\nPrinting for each item in the list, technologies.eachWithIndex { item, index -> println \"Technology: \$item at index \$index\" }"
technologies.eachWithIndex { item, index -> println "Technology: $item at index $index" }

//
// Sort list

technologies.sort()
println "technologies.sort() :\n\t $technologies"

technologies.addAll(['C#', 'Ruby'])
println "technologies.addAll(['C#','Ruby']) :\n\t $technologies"

// new sorted list without modifying the original list
def sortedTechnologies = technologies.sort(false)
println "sortedTechnologies = technologies.sort(false) :\n\tsortedTechnologies $sortedTechnologies \n\ttechnologies $technologies"

//Replace all elements in the list
Collections.replaceAll(technologies, 'Ruby', 'ruby')
println "Collections.replaceAll(technologies, 'Ruby', 'ruby') :\n\t $technologies"

//Shuffle a list
Collections.shuffle(technologies, new Random())
println "Collections.shuffle(technologies, new Random()) :\n\t $technologies"

// clear a list
technologies.clear()
println "technologies.clear() :\n\t $technologies"

//
// Maps
def devMap = [:]
println "devMap $devMap ${devMap.getClass()}"

devMap = ['name': 'John', 'age': 30]
println "devMap $devMap ${devMap.getClass()}"

devMap.put('lastName', 'Doe')
println "devMap.put('lastName', 'Doe') :\n\t $devMap"

println "devMap.each { key, value -> println \"key: \$key, value: \$value\" }"
devMap.each { key, value -> println "key: $key, value: $value" }

println "devMap.each { println \"key: \$it.key, value: \$it.value\" }"
devMap.each { println "key: $it.key, value: $it.value" }

println "devMap.eachWithIndex { entry, index -> println \"entry: \$entry, index: \$index\" }"
devMap.eachWithIndex { entry, index -> println "entry: $entry, index: $index" }

assert devMap.containsKey('name')
println "devMap.containsKey('name') :\n\t ${devMap.containsKey('name')}"

println "devMap.containsValue('Johnny')"
try {
    assert devMap.containsValue('Johnny')
} catch (AssertionError e) {
    println "Assertion failed: \n${e.message}"
}

println "devMap.keySet() :\n\t ${devMap.keySet()}"
println "devMap.values() :\n\t ${devMap.values()}"

devMap.remove('age')
println "devMap.remove('age') :\n\t $devMap"

//
// Groovy beans

class Foo {

    // read only property
    final String name = 'Roberto'

    // read only property with public getter and protected setter
    String language
    protected void setLanguage(String language) { this.language = language }

    // dynamically typed property
    def lastName

}

def foo = new Foo()
println "foo: \n\t$foo ${foo.getClass()}"

println "foo.name :\n\t ${foo.name}"

foo.language = 'Groovy'
println "foo.language = 'Groovy' :\n\t ${foo.language}"

foo.lastName = 'Gomez'
println "foo.lastName = 'Gomez' :\n\t ${foo.lastName}"

try {
    println "foo.name = 'Roberto' :"
    foo.name = 'Roberto'
} catch (groovy.lang.ReadOnlyPropertyException e) {
    println "\tException: ${e.message}"
}

//
// methods

def cowSay(message='moo') {
    println ' ' + '-' * message.size() + '--'
    println "| $message |"
    println ' ' + '-' * message.size() + '--'
    println '  \\   ^__^'
    println '   \\  (oo)\\_______'
    println '      (__)\\       )\\/\\'
    println '          ||----w |'
    println '          ||     ||'
}

println 'cowSay() :'
cowSay()

println "cowSay('Only miss the sun when it starts to snow') :"
cowSay('Only miss the sun when it starts to snow')

def greet(name) {
    return "Hello $name"
}

println "greet() :\n\t ${greet()}"

assert greet() == 'Hello null'
println "assert greet() == 'Hello null' :\n\t ${greet() == 'Hello null'}"

assert greet('Roberto') == 'Hello Roberto'
println "greet('Roberto') :\n\t ${greet('Roberto')}"
println "assert greet('Roberto') == 'Hello Roberto :\n\t ${greet('Roberto') == 'Hello Roberto'}"

//
// Logical operators

def a = 3

def checkA(a) {
    println "checkA(a = $a):"
    if (a == 1) {
        println "\ta == 1: ${a == 1} One"
    } else if (a == 2) {
        println "\ta == 2: ${a == 2} Two"
    } else {
        println "\ta is greater than 2: ${a > 2}"
    }
}

checkA(a)
checkA(1)
checkA(2)

// ternary
a = 5
def b = a == 3 ? 'a is 3' : 'a is not 3'
println "[a= $a] b = a == 3 ? 'a is 3' : 'a is not 3' :\n\tb: $b"

// elvis operator
def user = ['name': 'Elvis']
println "user: $user"

def name = user.name ?: 'Unknown'
println "name = user.name ?: 'Unknown' :\n\tname: $name"
