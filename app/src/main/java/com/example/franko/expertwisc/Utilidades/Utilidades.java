package com.example.franko.expertwisc.Utilidades;

/**
 * Created by FRANKO on 14/11/2017.
 */

public class Utilidades {
    //Variable de PageViewer
    public static int rotacion = 0;

    public static String R_cc = "Sin valor";
    public static String R_s = "Sin valor";
    public static String R_rd = "Sin valor";
    public static String R_co = "Sin valor";
    public static String R_cl = "Sin valor";
    public static String R_v = "Sin valor";
    public static String R_ln = "Sin valor";
    public static String R_m = "Sin valor";
    public static String R_c = "Sin valor";
    public static String R_bs = "Sin valor";
    public static String R_cf = "Sin valor";
    public static String R_a = "Sin valor";
    public static String R_i = "Sin valor";
    public static String R_ar = "Sin valor";
    public static String R_ad = "Sin valor";

    public static Boolean pantalla = true;

    public static int pages = 10;


    //Constantes Campo Usuario
    public static String TABLA_USUARIO = "usuario";
    public static String CAMPO_ID_USUARIO = "id_usuario";
    public static String CAMPO_NOMBRE_USUARIO = "nombre_usuario";
    public static String CAMPO_APELLIDO_USUARIO = "apellido_usuario";
    public static String CAMPO_USUARIO_USUARIO = "usuario_usuario";
    public static String CAMPO_CONTRASENA_USUARIO = "contrasena_usuario";
    public static String CAMPO_IMAGEN_USUARIO = "imagen_usuario";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+TABLA_USUARIO+
            " ("+
            CAMPO_ID_USUARIO +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
            CAMPO_NOMBRE_USUARIO+" TEXT, "+
            CAMPO_APELLIDO_USUARIO+" TEXT,"+
            CAMPO_USUARIO_USUARIO+" TEXT,"+
            CAMPO_CONTRASENA_USUARIO+" TEXT," +
            CAMPO_IMAGEN_USUARIO+" BLOB"+
            ")";
    public static final String INSERTAR_USUARIO_MASTER = "INSERT INTO "+TABLA_USUARIO+" VALUES ('admin','admin')";

    //Constantes Campo Pacientes
    public static String TABLA_PACIENTE = "paciente";
    public static String CAMPO_ID_PACIENTE = "id_paciente";
    public static String CAMPO_NOMBRES_PACIENTE = "nombres_paciente";
    public static String CAMPO_APELLIDOS_PACIENTE = "apellidos_paciente";
    public static String CAMPO_MOTIVO_CONSULTA_PACIENTE = "motivo_consulta_paciente";
    public static String CAMPO_ANTECEDENTES_PACIENTE = "antecedentes_paciente";
    public static String CAMPO_EDAD_PACIENTE = "edad_paciente";
    public static String CAMPO_IMAGEN_PACIENTE = "imagen_paciente";

    public static final String CREAR_TABLA_PACIENTE = "CREATE TABLE "+TABLA_PACIENTE+
            " ("+
            CAMPO_ID_PACIENTE + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_NOMBRES_PACIENTE + " TEXT, "+
            CAMPO_APELLIDOS_PACIENTE + " TEXT, "+
            CAMPO_MOTIVO_CONSULTA_PACIENTE + " TEXT, "+
            CAMPO_ANTECEDENTES_PACIENTE+ " TEXT, "+
            CAMPO_EDAD_PACIENTE +" TEXT, "+
            CAMPO_IMAGEN_PACIENTE+" BLOB"+
            ")";

    //Constantes Tabla Test
    public static final String TABLA_TEST = "test";
    public static final String CAMPO_ID_TEST = "id_test";
    public static final String CAMPO_RES_CC= "res_cc";
    public static final String CAMPO_RES_S= "res_s";
    public static final String CAMPO_RES_RD= "res_rd";
    public static final String CAMPO_RES_CO= "res_co";
    public static final String CAMPO_RES_CL= "res_cl";
    public static final String CAMPO_RES_V= "res_v";
    public static final String CAMPO_RES_LN= "res_ln";
    public static final String CAMPO_RES_M= "res_m";
    public static final String CAMPO_RES_C= "res_c";
    public static final String CAMPO_RES_BS= "res_bs";
    public static final String CAMPO_RES_CF= "res_cf";
    public static final String CAMPO_RES_A= "res_a";
    public static final String CAMPO_RES_I= "res_i";
    public static final String CAMPO_RES_AR= "res_ar";
    public static final String CAMPO_RES_AD= "res_ad";

    public static final String CREAR_TABLA_TEST = "CREATE TABLE" +TABLA_TEST+
            " ("+
            CAMPO_ID_TEST + "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
            CAMPO_ID_PACIENTE + " INTEGER, "+
            CAMPO_RES_CC + " TEXT, "+
            CAMPO_RES_S + " TEXT, "+
            CAMPO_RES_RD + " TEXT, "+
            CAMPO_RES_CO + " TEXT, "+
            CAMPO_RES_CL + " TEXT, "+
            CAMPO_RES_V + " TEXT, "+
            CAMPO_RES_LN+ " TEXT, "+
            CAMPO_RES_M + " TEXT, "+
            CAMPO_RES_C + " TEXT, "+
            CAMPO_RES_BS+ " TEXT, "+
            CAMPO_RES_CF + " TEXT, "+
            CAMPO_RES_A + " TEXT, "+
            CAMPO_RES_I + " TEXT, "+
            CAMPO_RES_AR + " TEXT, "+
            CAMPO_RES_AD + " TEXT )";


    //Constantes Campo Puntuaciones
    public static String TABLA_PUNTUACIONES_CC = "puntuacion_cc";
    public static String CAMPO_ID_PUNTUACION_CC = "id_puntuacion_cc";
    public static String CAMPO_CC = "campo_cc"; //CC1
    public static String CAMPO_CCS = "campo_ccs"; //CC2

    public static String TABLA_PUNTUACIONES_S = "puntuacion_s";
    public static String CAMPO_ID_PUNTUACION_S = "id_puntuacion_s";
    public static String CAMPO_S = "campo_s";

    public static String TABLA_PUNTUACIONES_RD = "puntuacion_rd";
    public static String CAMPO_ID_PUNTUACION_RD = "id_puntuacion_rd";
    public static String CAMPO_RDD = "campo_rdd";
    public static String CAMPO_RDI = "campo_rdi";
    public static String CAMPO_RDT = "campo_rdt";

    public static String TABLA_PUNTUACIONES_Co = "puntuacion_co";
    public static String CAMPO_ID_PUNTUACION_Co = "id_puntuacion_co";
    public static String CAMPO_Co = "puntuacion_co";

    public static String TABLA_PUNTUACIONES_CL = "puntuacion_cl";
    public static String CAMPO_ID_PUNTUACION_CL = "id_puntuacion_cl";
    public static String CAMPO_CL = "campo_cl";

    public static String TABLA_PUNTUACIONES_V = "puntuacion_v";
    public static String CAMPO_ID_PUNTUACION_V = "id_puntuacion_v";
    public static String CAMPO_V = "campo_v";

    public static String TABLA_PUNTUACIONES_LN = "puntuacion_ln";
    public static String CAMPO_ID_PUNTUACION_LN = "id_puntuacion_ln";
    public static String CAMPO_LN = "campo_ln";

    public static String TABLA_PUNTUACIONES_M = "puntuacion_m";
    public static String CAMPO_ID_PUNTUACION_M = "id_puntuacion_m";
    public static String CAMPO_M = "campo_m";

    public static String TABLA_PUNTUACIONES_C = "puntuacion_c";
    public static String CAMPO_ID_PUNTUACION_C = "id_puntuacion_c";
    public static String CAMPO_C = "campo_c";

    public static String TABLA_PUNTUACIONES_BS = "puntuacion_bs";
    public static String CAMPO_ID_PUNTUACION_BS = "id_puntuacion_bs";
    public static String CAMPO_BS = "campo_bs";

    public static String TABLA_PUNTUACIONES_CF = "puntuacion_cf";
    public static String CAMPO_ID_PUNTUACION_CF = "id_puntuacion_cf";
    public static String CAMPO_CF = "campo_cf";

    public static String TABLA_PUNTUACIONES_A = "puntuacion_a";
    public static String CAMPO_ID_PUNTUACION_A = "id_puntuacion_a";
    public static String CAMPO_A = "campo_a";

    public static String TABLA_PUNTUACIONES_I = "puntuacion_i";
    public static String CAMPO_ID_PUNTUACION_I = "id_puntuacion_i";
    public static String CAMPO_I = "campo_i";

    public static String TABLA_PUNTUACIONES_Ar = "puntuacion_ar";
    public static String CAMPO_ID_PUNTUACION_Ar = "id_puntuacion_ar";
    public static String CAMPO_Ar = "campo_ar";

    public static String TABLA_PUNTUACIONES_Ad = "puntuacion_ad";
    public static String CAMPO_ID_PUNTUACION_Ad = "id_puntuacion_ad";
    public static String CAMPO_Ad = "campo_ad";

    public static String TABLA_INTERVALO = "intervalo";
    public static String CAMPO_ID_INTERVALO = "id_intervalo";
    public static String CAMPO_INTERVALO = "campo_intervalo";

    public static String TABLA_ESCALAR= "escalar";
    public static String CAMPO_ID_ESCALAR= "id_escalar";
    public static String CAMPO_ICV = "campo_icv";
    public static String CAMPO_IRP = "campo_irp";
    public static String CAMPO_IMO = "campo_imo";
    public static String CAMPO_IVP = "campo_ivp";
    public static String CAMPO_CIT = "campo_cit";

    //Tabla Puntuaciones 2
    public static String TABLA_PUNTUACIONES= "puntuaciones";
    public static String CAMPO_ID_PUNTUACIONES ="id_puntuacion";
    public static String CAMPO_PUNTUACION_CC = "id_puntuacion_cc";
    public static String CAMPO_PUNTUACION_CCS = "id_puntuacion_ccs";
    public static String CAMPO_PUNTUACION_S = "id_puntuacion_s";
    public static String CAMPO_PUNTUACION_RDD = "id_puntuacion_rdd";
    public static String CAMPO_PUNTUACION_RDI = "id_puntuacion_rdi";
    public static String CAMPO_PUNTUACION_RDT = "id_puntuacion_rdt";
    public static String CAMPO_PUNTUACION_CO = "id_puntuacion_co";
    public static String CAMPO_PUNTUACION_CL = "id_puntuacion_cl";
    public static String CAMPO_PUNTUACION_V = "id_puntuacion_v";
    public static String CAMPO_PUNTUACION_LN = "id_puntuacion_ln";
    public static String CAMPO_PUNTUACION_M = "id_puntuacion_m";
    public static String CAMPO_PUNTUACION_C = "id_puntuacion_c";
    public static String CAMPO_PUNTUACION_BS = "id_puntuacion_bs";
    public static String CAMPO_PUNTUACION_CF = "id_puntuacion_cf";
    public static String CAMPO_PUNTUACION_A = "id_puntuacion_a";
    public static String CAMPO_PUNTUACION_I = "id_puntuacion_i";
    public static String CAMPO_PUNTUACION_AR = "id_puntuacion_ar";
    public static String CAMPO_PUNTUACION_AD = "id_puntuacion_ad";


    public static final String CREAR_TABLA_PUNTUACIONES_CC = "CREATE TABLE "+TABLA_PUNTUACIONES_CC+
            "("+
            CAMPO_ID_PUNTUACION_CC +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_CC + " TEXT, "+
            CAMPO_CCS + " TEXT ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_S = "CREATE TABLE "+TABLA_PUNTUACIONES_S+
            "("+
            CAMPO_ID_PUNTUACION_S +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_S + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_RD = "CREATE TABLE "+TABLA_PUNTUACIONES_RD+
            "("+
            CAMPO_ID_PUNTUACION_RD +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_RDD + " TEXT, "+
            CAMPO_RDI + " TEXT, "+
            CAMPO_RDT + " TEXT ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_Co = "CREATE TABLE "+TABLA_PUNTUACIONES_Co+
            "("+
            CAMPO_ID_PUNTUACION_Co +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_Co + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_CL = "CREATE TABLE "+TABLA_PUNTUACIONES_CL+
            "("+
            CAMPO_ID_PUNTUACION_CL +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_CL + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_V= "CREATE TABLE "+TABLA_PUNTUACIONES_V+
            "("+
            CAMPO_ID_PUNTUACION_V +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_V + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_LN = "CREATE TABLE "+TABLA_PUNTUACIONES_LN+
            "("+
            CAMPO_ID_PUNTUACION_LN +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_LN + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_M = "CREATE TABLE "+TABLA_PUNTUACIONES_M+
            "("+
            CAMPO_ID_PUNTUACION_M +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_M + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_C = "CREATE TABLE "+TABLA_PUNTUACIONES_C+
            "("+
            CAMPO_ID_PUNTUACION_C +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_C + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_BS = "CREATE TABLE "+TABLA_PUNTUACIONES_BS+
            "("+
            CAMPO_ID_PUNTUACION_BS +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_BS + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_CF = "CREATE TABLE "+TABLA_PUNTUACIONES_CF+
            "("+
            CAMPO_ID_PUNTUACION_CF +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_CF + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_A = "CREATE TABLE "+TABLA_PUNTUACIONES_A+
            "("+
            CAMPO_ID_PUNTUACION_A +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_A + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_I = "CREATE TABLE "+TABLA_PUNTUACIONES_I+
            "("+
            CAMPO_ID_PUNTUACION_I +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_I + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_Ar = "CREATE TABLE "+TABLA_PUNTUACIONES_Ar+
            "("+
            CAMPO_ID_PUNTUACION_Ar +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_Ar + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_Ad = "CREATE TABLE "+TABLA_PUNTUACIONES_Ad+
            "("+
            CAMPO_ID_PUNTUACION_Ad +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_Ad + " TEXT )";

    public static final String CREAR_TABLA_INTERVALO = "CREATE TABLE "+TABLA_INTERVALO+
            "("+
            CAMPO_ID_INTERVALO +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_INTERVALO + " INTEGER )";

    public static final String CREAR_TABLA_ESCALAR = "CREATE TABLE "+TABLA_ESCALAR+
            "("+
            CAMPO_ID_ESCALAR +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_ICV + " TEXT, "+
            CAMPO_IRP + " TEXT, "+
            CAMPO_IMO + " TEXT, "+
            CAMPO_IVP + " TEXT, "+
            CAMPO_CIT + " TEXT ) ";

    public static final String CREAR_TABLA_PUNTUACIONES = "CREATE TABLE "+TABLA_PUNTUACIONES+
            "("+
            CAMPO_PUNTUACION_CC+" TEXT, "+
            CAMPO_PUNTUACION_CCS+" TEXT, "+
            CAMPO_PUNTUACION_S+" TEXT, "+
            CAMPO_PUNTUACION_RDD+" TEXT, "+
            CAMPO_PUNTUACION_RDI+" TEXT, "+
            CAMPO_PUNTUACION_RDT+" TEXT, "+
            CAMPO_PUNTUACION_CO+" TEXT, "+
            CAMPO_PUNTUACION_CL+" TEXT, "+
            CAMPO_PUNTUACION_V+" TEXT, "+
            CAMPO_PUNTUACION_LN+" TEXT, "+
            CAMPO_PUNTUACION_M+" TEXT, "+
            CAMPO_PUNTUACION_C+" TEXT, "+
            CAMPO_PUNTUACION_BS+" TEXT, "+
            CAMPO_PUNTUACION_CF+" TEXT, "+
            CAMPO_PUNTUACION_A+" TEXT, "+
            CAMPO_PUNTUACION_AR+" TEXT, "+
            CAMPO_PUNTUACION_AD+" TEXT )";
}
