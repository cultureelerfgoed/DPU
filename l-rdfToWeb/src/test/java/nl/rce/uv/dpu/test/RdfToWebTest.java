package nl.rce.uv.dpu.test;

import cz.cuni.mff.xrg.odcs.dpu.test.TestEnvironment;
import eu.unifiedviews.dataunit.files.FilesDataUnit;
import eu.unifiedviews.dataunit.rdf.WritableRDFDataUnit;
import eu.unifiedviews.helpers.dataunit.rdf.RDFHelper;
import eu.unifiedviews.helpers.dpu.test.config.ConfigurationBuilder;
import nl.rce.uv.dpu.RdfToWeb;
import nl.rce.uv.dpu.RdfToWebConfig_V1;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryResult;
import org.junit.Test;

public class RdfToWebTest {

    @Test
    public void execute() throws Exception {
        // Prepare config.
        RdfToWebConfig_V1 config = new RdfToWebConfig_V1();

        // Prepare DPU.
        RdfToWeb dpuInstance = new RdfToWeb();
        dpuInstance.configure((new ConfigurationBuilder()).setDpuConfiguration(config).toString());

        // Prepare test environment.
        TestEnvironment environment = new TestEnvironment();

        // Prepare data unit.
        FilesDataUnit filesInput = environment.createFilesInputFromResource("input", "cities.csv");
        WritableRDFDataUnit rdfOutput = environment.createRdfOutput("rdfOutput",false);

        try {
            // Run.
            environment.run(dpuInstance);

            //check the output, if it satisfies your requirements. You standard approaches for examining data units.
            RDFHelper.getGraphs(rdfOutput);
            RepositoryConnection connection = null;
            try {
                connection = rdfOutput.getConnection();
                RepositoryResult<Statement> statements = connection.getStatements(null, null, null, false);

                while(statements.hasNext()) {
                    //TODO Assert
                }
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        } finally {
            // Release resources.
            environment.release();
        }
    }
}
