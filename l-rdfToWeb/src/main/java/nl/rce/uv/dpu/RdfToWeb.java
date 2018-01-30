package nl.rce.uv.dpu;

import eu.unifiedviews.dataunit.DataUnit;
import eu.unifiedviews.dataunit.rdf.RDFDataUnit;
import eu.unifiedviews.dpu.DPU;
import eu.unifiedviews.dpu.DPUException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.unifiedviews.helpers.dpu.config.ConfigHistory;
import eu.unifiedviews.helpers.dpu.context.ContextUtils;
import eu.unifiedviews.helpers.dpu.exec.AbstractDpu;
import eu.unifiedviews.helpers.dpu.extension.ExtensionInitializer;
import eu.unifiedviews.helpers.dpu.extension.faulttolerance.FaultTolerance;

/**
 * Main data processing unit class.
 *
 * @author Unknown
 */
@DPU.AsLoader
public class RdfToWeb extends AbstractDpu<RdfToWebConfig_V1> {

    private static final Logger log = LoggerFactory.getLogger(RdfToWeb.class);

    @DataUnit.AsInput(name = "rdfInput")
    public RDFDataUnit rdfInput;

	public RdfToWeb() {
		super(RdfToWebVaadinDialog.class, ConfigHistory.noHistory(RdfToWebConfig_V1.class));
	}
		
    @Override
    protected void innerExecute() throws DPUException {

        ContextUtils.sendShortInfo(ctx, "RdfToWeb.message");
        
    }
	
}
