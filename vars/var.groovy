#!/bin/usr/groovy
import org.foo.scm.*

def call(body)
{
   def config = [:]
   body.resolveStrategy = Closure.DELEGATE_FIRST
   body.delegate = config
   body()
       stage ('\u2776 Code Checkout') {
           def git = new git()
           git.Checkout("${config.GIT_URL}","${config.BRANCH_NAME}")
           author_name = git.getCommitAuthorComplete()
           println(author_name).trim()

    }
}
