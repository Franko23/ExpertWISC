package com.example.franko.expertwisc.Utilidades;

/**
 * Created by FRANKO on 14/11/2017.
 */

public class Utilidades {
    //Variable de PageViewer
    public static int rotacion = 0;

    public static String edadActual; //Edad del paciente actual

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

    public static int currentUserIdPersona=0;//Id_persona del usuario actual
    public static int currentUserIdUsuario=0;//Id_usuario del usuario actual

    public static Boolean disable = false;


    //Constantes Campo Persona
    public static String TABLA_PERSONA = "persona";
    public static String CAMPO_ID_PERSONA = "id_persona";
    public static String CAMPO_NOMBRE_PERSONA = "nombre_persona";
    public static String CAMPO_APELLIDO_PERSONA = "apellido_persona";
    public static String CAMPO_FECHA_NACIMIENTO_PERSONA = "edad_persona";
    public static String CAMPO_IMAGEN_PERSONA = "imagen_persona";
    public static String CAMPO_TIPO_PERSONA = "tipo_persona";

    //Constantes Campo Pacientes
    public static String TABLA_PACIENTE = "paciente";
    public static String CAMPO_ID_PACIENTE = "id_paciente";
    public static String CAMPO_MOTIVO_CONSULTA_PACIENTE = "motivo_consulta_paciente";
    public static String CAMPO_ANTECEDENTES_PACIENTE = "antecedentes_paciente";

    //Constantes Campo Usuario
    public static String TABLA_USUARIO = "usuario";
    public static String CAMPO_ID_USUARIO = "id_usuario";
    public static String CAMPO_NOMBRE_USUARIO = "nombre_usuario";
    public static String CAMPO_CONTRASENA_USUARIO = "contrasena_usuario";
    public static String CAMPO_ACTIVO_USUARIO = "activo_usuario";

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

    public static String TABLA_PUNTUACIONES_CO = "puntuacion_co";
    public static String CAMPO_ID_PUNTUACION_CO = "id_puntuacion_co";
    public static String CAMPO_CO = "puntuacion_co";

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

    public static String TABLA_PUNTUACIONES_AR = "puntuacion_ar";
    public static String CAMPO_ID_PUNTUACION_AR = "id_puntuacion_ar";
    public static String CAMPO_AR = "campo_ar";

    public static String TABLA_PUNTUACIONES_AD = "puntuacion_ad";
    public static String CAMPO_ID_PUNTUACION_AD = "id_puntuacion_ad";
    public static String CAMPO_AD = "campo_ad";

    //Constantes campo intervalo

    public static String TABLA_INTERVALO = "intervalo";
    public static String CAMPO_ID_INTERVALO = "id_intervalo";
    public static String CAMPO_INTERVALO = "campo_intervalo";

    //Constantes tabla 1

    public static String TABLA_ESCALAR = "escalar";
    public static String CAMPO_ID_ESCALAR = "id_escalar";
    public static String CAMPO_ICV = "campo_icv";
    public static String CAMPO_IRP = "campo_irp";
    public static String CAMPO_IMO = "campo_imo";
    public static String CAMPO_IVP = "campo_ivp";
    public static String CAMPO_CIT = "campo_cit";


    public static final String CREAR_TABLA_PUNTUACIONES_CC = "CREATE TABLE " + TABLA_PUNTUACIONES_CC +
            "(" +
            CAMPO_ID_PUNTUACION_CC + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_CC + " TEXT, " +
            CAMPO_CCS + " TEXT ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_S = "CREATE TABLE " + TABLA_PUNTUACIONES_S +
            "(" +
            CAMPO_ID_PUNTUACION_S + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_S + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_RD = "CREATE TABLE " + TABLA_PUNTUACIONES_RD +
            "(" +
            CAMPO_ID_PUNTUACION_RD + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_RDD + " TEXT, " +
            CAMPO_RDI + " TEXT, " +
            CAMPO_RDT + " TEXT ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_CO = "CREATE TABLE " + TABLA_PUNTUACIONES_CO +
            "(" +
            CAMPO_ID_PUNTUACION_CO + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_CO + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_CL = "CREATE TABLE " + TABLA_PUNTUACIONES_CL +
            "(" +
            CAMPO_ID_PUNTUACION_CL + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_CL + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_V = "CREATE TABLE " + TABLA_PUNTUACIONES_V +
            "(" +
            CAMPO_ID_PUNTUACION_V + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_V + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_LN = "CREATE TABLE " + TABLA_PUNTUACIONES_LN +
            "(" +
            CAMPO_ID_PUNTUACION_LN + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_LN + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_M = "CREATE TABLE " + TABLA_PUNTUACIONES_M +
            "(" +
            CAMPO_ID_PUNTUACION_M + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_M + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_C = "CREATE TABLE " + TABLA_PUNTUACIONES_C +
            "(" +
            CAMPO_ID_PUNTUACION_C + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_C + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_BS = "CREATE TABLE " + TABLA_PUNTUACIONES_BS +
            "(" +
            CAMPO_ID_PUNTUACION_BS + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_BS + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_CF = "CREATE TABLE " + TABLA_PUNTUACIONES_CF +
            "(" +
            CAMPO_ID_PUNTUACION_CF + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_CF + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_A = "CREATE TABLE " + TABLA_PUNTUACIONES_A +
            "(" +
            CAMPO_ID_PUNTUACION_A + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_A + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_I = "CREATE TABLE " + TABLA_PUNTUACIONES_I +
            "(" +
            CAMPO_ID_PUNTUACION_I + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_I + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_AR = "CREATE TABLE " + TABLA_PUNTUACIONES_AR +
            "(" +
            CAMPO_ID_PUNTUACION_AR + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_AR + " TEXT )";

    public static final String CREAR_TABLA_PUNTUACIONES_AD = "CREATE TABLE " + TABLA_PUNTUACIONES_AD +
            "(" +
            CAMPO_ID_PUNTUACION_AD + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_AD + " TEXT )";

    //Constantes Tabla Test
    public static final String TABLA_TEST = "test";
    public static final String CAMPO_ID_TEST = "id_test";
    public static final String CAMPO_FECHA_TEST = "fecha_test";
    public static final String CAMPO_EVALUADOR_TEST = "evaluador_test";
    public static final String CAMPO_ESTADO_TEST = "estado_test";

    public static final String CREAR_TABLA_TEST = "CREATE TABLE " + TABLA_TEST +
            " (" +
            CAMPO_ID_TEST + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_FECHA_TEST + " TEXT, " +
            CAMPO_EVALUADOR_TEST + " TEXT, " +
            CAMPO_ESTADO_TEST + " TEXT, " +
            CAMPO_ID_PACIENTE + " INTEGER," +
            CAMPO_ID_PUNTUACION_CC + " INTEGER," +
            CAMPO_ID_PUNTUACION_S + " INTEGER," +
            CAMPO_ID_PUNTUACION_RD + " INTEGER," +
            CAMPO_ID_PUNTUACION_CO + " INTEGER," +
            CAMPO_ID_PUNTUACION_CL + " INTEGER," +
            CAMPO_ID_PUNTUACION_V + " INTEGER," +
            CAMPO_ID_PUNTUACION_LN + " INTEGER," +
            CAMPO_ID_PUNTUACION_M + " INTEGER," +
            CAMPO_ID_PUNTUACION_C + " INTEGER," +
            CAMPO_ID_PUNTUACION_BS + " INTEGER," +
            CAMPO_ID_PUNTUACION_CF + " INTEGER," +
            CAMPO_ID_PUNTUACION_A + " INTEGER," +
            CAMPO_ID_PUNTUACION_I + " INTEGER," +
            CAMPO_ID_PUNTUACION_AR + " INTEGER," +
            CAMPO_ID_PUNTUACION_AD + " INTEGER )";


    public static final String CREAR_TABLA_PACIENTE = "CREATE TABLE " + TABLA_PACIENTE +
            " (" +
            CAMPO_ID_PACIENTE + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_MOTIVO_CONSULTA_PACIENTE + " TEXT, " +
            CAMPO_ANTECEDENTES_PACIENTE + " TEXT, " +
            CAMPO_ID_PERSONA+" INTEGER, "+
            CAMPO_ID_USUARIO+" INTEGER "+
            ")";

    public static final String CREAR_TABLA_PERSONA = "CREATE TABLE " + TABLA_PERSONA +
            "(" +
            CAMPO_ID_PERSONA + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_NOMBRE_PERSONA + " TEXT, " +
            CAMPO_APELLIDO_PERSONA + " TEXT, " +
            CAMPO_FECHA_NACIMIENTO_PERSONA+ " TEXT, " +
            CAMPO_IMAGEN_PERSONA + " BLOB,"+
            CAMPO_TIPO_PERSONA + " TEXT )";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE " + TABLA_USUARIO +
            " (" +
            CAMPO_ID_USUARIO + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_NOMBRE_USUARIO + " TEXT, " +
            CAMPO_CONTRASENA_USUARIO + " TEXT," +
            CAMPO_ID_PERSONA+" INTEGER"+
            ")";


    public static final String CREAR_TABLA_INTERVALO = "CREATE TABLE " + TABLA_INTERVALO +
            "(" +
            CAMPO_ID_INTERVALO + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_INTERVALO + " INTEGER )";


    public static final String CREAR_TABLA_ESCALAR = "CREATE TABLE " + TABLA_ESCALAR +
            "(" +
            CAMPO_ID_ESCALAR + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_ICV + " TEXT, " +
            CAMPO_IRP + " TEXT, " +
            CAMPO_IMO + " TEXT, " +
            CAMPO_IVP + " TEXT, " +
            CAMPO_CIT + " TEXT ) ";

}
