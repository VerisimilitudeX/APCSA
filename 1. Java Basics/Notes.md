# Unit 1 Notes: Primitive Types

> AP Exam Weighting: 2.5–5%

In this unit, we will introduce the basics of primitive types in the Java programming language. By the end of this unit, you should be able to:

* Declare and initialize variables of primitive types in Java.
* Use expressions and assignment statements in Java.
* Use compound assignment operators in Java.
* Understand type casting and the range of values that can be stored in different primitive types in Java.

## Why Programming? Why Java?

Programming is the process of creating solutions to problems by telling a computer what to do. Programming is used in a wide range of fields, including science, business, and entertainment.

Java is a popular programming language that is widely used for building a variety of applications, including web applications, mobile applications, and games. It is known for its simplicity, flexibility, and portability.

## Variables and Data Types

In programming, a variable is a named storage location that holds a value. In Java, there are several different types of variables, known as primitive types. The eight primitive types in Java are:

1. <b>boolean</b>: This type represents a true or false value.
2. <b>byte</b>: This type represents an 8-bit signed integer.
3. <b>char</b>: This type represents a 16-bit Unicode character.
4. <b>short</b>: This type represents a 16-bit signed integer.
5. <b>int</b>: This type represents a 32-bit signed integer.
6. <b>long</b>: This type represents a 64-bit signed integer.
7. <b>float</b>: This type represents a single-precision 32-bit floating-point number.
8. <b>double</b>: This type represents a double-precision 64-bit floating-point number.

To declare a variable of a primitive type, you need to specify the type and the name of the variable. For example:

```java
int myInt;
double myDouble;
char myChar;
```

You can also initialize the variable when you declare it by assigning a value to it. For example:

```java
int myInt = 5;
double myDouble = 3.14;
char myChar = 'a';
```

## Expressions and Assignment Statements

An expression is a combination of values, variables, and operators that produces a result. In Java, you can use various operators to perform operations on values and variables. Some common operators in Java include:

* Arithmetic operators: `+`, `-`, `*`, `/`, `%`
* Comparison operators: `==`, `!=`, `>`, `<`, `>=`, `<=`
* Logical operators: `&&`, `||`, `!`

An assignment statement is a statement that assigns a value to a variable. In Java, you use the assignment operator `=` to assign a value to a variable. For example:

```java
int x = 5;
double y = 3.14;
char z = 'a';
```

## Compound Assignment Operators

In Java, you can use compound assignment operators to perform an operation and assign the result to a variable in a single statement. Some common compound assignment operators in Java include:

* `+=`: Add and assign
* `-=`: Subtract and assign
* `*=`: Multiply and assign
* `/=`: Divide and assign

For example:

```java
int x = 5;
x += 2; // x is now equal to 7
x -= 3; // x is now equal to 4
x *= 4; // x is now equal to 16
x /= 8; // x is now equal to 2
```

Using compound assignment operators can be more efficient than using the equivalent operation and assignment statements separately.

## Casting and Ranges of Variables

In Java, type casting is the process of converting a value from one data type to another. For example, you might want to convert a `double` value to an `int` value. To do this, you can use a type cast operator, which is the name of the target type in parentheses. For example:

```java
double myDouble = 3.14;
int myInt = (int) myDouble; // myInt is now equal to 3
```

It's important to note that type casting can result in data loss if the value being cast is too large or too small to fit in the target type. For example, if you try to cast a `long` value to an `int` value, you will lose precision if the `long` value is too large to fit in an `int`.

Each primitive type has a range of values that it can store. For example, an `int` can store any integer (a positive or negative whole number) value between -2147483648 and 2147483647. If you try to assign a value outside of this range to an `int` variable, you will get an error.

```java
int myInt = 2147483648; // This will cause an error
```

It's important to choose the appropriate primitive type for your variables based on the range of values you need to store.

## Summary

In this unit, we introduced the basics of programming and the Java programming language. We learned about primitive types and how to declare and initialize variables in Java. We also learned about expressions, assignment statements, and compound assignment operators. Finally, we learned about type casting and the range of values that can be stored in different primitive types.