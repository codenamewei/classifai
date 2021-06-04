import ai.classifai.database.DbConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Slf4j
public class DbSetup {

    final static String dataRootPath = DbConfig.getDbRootPath();
    final static String dbBackup = "src/main/resources/originalDbBackup/.classifai";
    final static String testDbResult = "src/main/resources/testDbResult/.classifai";
    final static String testDb = "src/main/resources/testDb/.classifai";

    public static void backupOriginalDatabase() throws IOException {
        log.info("\nBackup existing database\n" +
                "From: " + dataRootPath +
                "\n To: " + dbBackup);

        if(Paths.get(dataRootPath).toFile().exists()) {
            FileUtils.copyDirectory(
                    new File(dataRootPath),
                    new File(dbBackup)
            );

            FileUtils.deleteDirectory(new File(dataRootPath));
        }

    }

    public static void copyTestDbToUserPath() throws IOException {
        log.info("Copy Empty Db for test");
        FileUtils.copyDirectory(
                new File(testDb),
                new File(dataRootPath)
        );
    }

    public static void restoreOriginalDatabase(boolean cleanTestResult) throws IOException {
        log.info("Restoring existing database");

        // Copy result of test database if wanted for further checking
        if(cleanTestResult) {
            log.info("Copy Test Db");
            FileUtils.copyDirectory(
                    new File(dataRootPath),
                    new File(testDbResult)
            );
        }

        // Restore existing directory from copied path
        FileUtils.copyDirectory(
                new File(dbBackup),
                new File(dataRootPath)
        );

        // Delete backup directory
        FileUtils.deleteDirectory(new File(dbBackup));

    }
}
