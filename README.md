# IN HALTER TEMPLATE FINITESTATEMACHINE - Simple Finite State Machine

## Project: Scala and Java 8 with Lambda Template for a Akka AbstractFSM

## Use it - define in your build.gradle file

`dependencies {`

`  // use at runtime`

`  // API`

`compile "in.halter.template-api:in.halter.finite-state-machine-api:1.0"`

`  // Implementation`

`compile "in.halter.template-impl:in.halter.finite-state-machine-impl:1.0"`

`}`

## Download
 [ ![Download](https://api.bintray.com/packages/roebi/maven/in.halter.finite-state-machine/images/download.svg) ](https://bintray.com/roebi/maven/in.halter.finite-state-machine/_latestVersion)

## Build Status
[![Build Status](https://drone.io/github.com/roebi/in-halter-template_finite-state-machine/status.png)](https://drone.io/github.com/roebi/in-halter-template_finite-state-machine/latest)

## The Finite State Machine Template

contains

- a Scala Implementation `class SimpleFSMS extends AbstractFSM[SimpleFSMS.State, SimpleFSMS.Data]`  
- and its Scala Testclass `class SimpleFSMSTest`

contains

- a Java 8 with Lambda Implementation `public class SimpleFSMJ extends AbstractFSM<SimpleState, Data>`  
- and its Java Testclass `public class SimpleFSMJTest`

## Compare the Scala Implementation with the Java 8 with Lambda Implementation ...	
 
The Scala Implementation `SimpleFSMS`

- use a `trait` for the FSM State
- use a `case class` for the FSM Data
- use `case object` 's for States
- use `case object` 's for Event Messages 

The Java 8 with Lambda Implementation `SimpleFSMJ` 

- use a `interface` for the FSM State
- use a `interface` for the FSM Data
- use `enum` 's for States
- use `object` 's for Event Messages
