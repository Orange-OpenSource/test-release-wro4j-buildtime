This is an example project for [wro4j-taglib](https://github.com/Orange-OpenSource/wro4j-taglib).

We tried to have a configuration which generates processed files in `target/` so that `mvn clean` can remove it
and we don't commit files by error.

However it is difficult to make it work both with a command line built and with the eclipse plugin 
[m2e-wro](http://download.jboss.org/jbosstools/updates/m2e-wro4j/) with WTP,
particularly when we use the CSS url rewriting feature (which we need most of the time).

In this configuration, we can use the debug mode thanks to the taglib, which works correctly
because the original files are used. Then when we build from command line, the css url rewriter
works correctly as well. Only when you try to use the wro-generated files directly from Eclipse WTP
the URLs in CSS are incorrect.

