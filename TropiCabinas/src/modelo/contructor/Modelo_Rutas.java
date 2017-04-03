/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.contructor;

import java.net.URL;

/**
 *
 * @author ace
 */
public class Modelo_Rutas {

    private final String dbOracle = "/controlador/dboracle.properties";
    private final String dbMysql = "/com/credencials.properties";
    private final String dbPostgres = "/com/dbpostgres.properties";
    private final String dbSqlServer = "/com/dbsqlserver.properties";

    public URL getFileDbOracle() {
        return getClass().getResource(dbOracle);
    }

    public URL getFileDbMysql() {
        return getClass().getResource(dbMysql);
    }

    public URL getFileDbPostgres() {
        return getClass().getResource(dbPostgres);
    }

    public URL getFileDbSqlServer() {
        return getClass().getResource(dbSqlServer);
    }
}
