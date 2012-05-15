/*
 * public domain
 */
package ro.isdc.wro.examples.buildtime;

import ro.isdc.wro.extensions.processor.css.YUICssCompressorProcessor;
import ro.isdc.wro.extensions.processor.js.UglifyJsProcessor;
import ro.isdc.wro.manager.factory.standalone.DefaultStandaloneContextAwareManagerFactory;
import ro.isdc.wro.model.resource.processor.factory.ProcessorsFactory;
import ro.isdc.wro.model.resource.processor.factory.SimpleProcessorsFactory;
import ro.isdc.wro.model.resource.processor.impl.css.CssImportPreProcessor;
import ro.isdc.wro.model.resource.processor.impl.css.CssUrlRewritingProcessor;
import ro.isdc.wro.model.resource.processor.impl.js.SemicolonAppenderPreProcessor;
import ro.isdc.wro.model.resource.util.TimestampNamingStrategy;

public class CustomWroManagerFactory extends
		DefaultStandaloneContextAwareManagerFactory {
	public CustomWroManagerFactory() {
		setNamingStrategy(new TimestampNamingStrategy());
		
	}
	
	@Override
	protected ProcessorsFactory newProcessorsFactory() {
	    final SimpleProcessorsFactory factory = new SimpleProcessorsFactory();
	    factory.addPreProcessor(new CssImportPreProcessor());
	    factory.addPreProcessor(new CssUrlRewritingProcessor());
	    factory.addPreProcessor(new SemicolonAppenderPreProcessor());
	    factory.addPreProcessor(new YUICssCompressorProcessor());
	    factory.addPreProcessor(new UglifyJsProcessor());

	    //factory.addPostProcessor(new CssVariablesProcessor());
	    //factory.addPostProcessor(new UglifyJsProcessor());

	    return factory;
	}

}
