#!/bin/usr/groovy
import org.foo.scm.*

def call(body)
{
   def config = [:]
   body.resolveStrategy = Closure.DELEGATE_FIRST
   body.delegate = config
   body()
   timestamps {
           def git = new git()
           git.Checkout("${config.GIT_URL}","${config.BRANCH}","${config.GIT_CREDENTIALS}")
  println(env.GIT_BRANCH)

    }
}
