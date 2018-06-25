package com.example.franko.expertwisc.Utilidades;

import com.example.franko.expertwisc.FragmentosSubTest.S;

import java.util.List;

/**
 * Created by FRANKO on 14/11/2017.
 */

public class Utilidades {
    //Variable de PageViewer
    public static int rotacionG = 0;
    public static int rotacionR = 0;
    public static int rotacionFab = 0;

    public static String edadActual; //Edad del paciente actual

    public static String R_cc;
    public static String R_s;
    public static String R_rd;
    public static String R_co;
    public static String R_cl;
    public static String R_v;
    public static String R_ln;
    public static String R_m;
    public static String R_c;
    public static String R_bs;
    public static String R_cf;
    public static String R_a;
    public static String R_i;
    public static String R_ar;
    public static String R_ad;

    public static List<String> listResultEscalar;
    public static List<String> listResultCompuesta;

    public static String icv;
    public static String irp;
    public static String imo;
    public static String ivp;
    public static String cit;

    public static String intervalo_confianza;

    public static Boolean pantalla = true;

    public static int pages = 10;

    public static int currentUserIdPersona = 0;//Id_persona del usuario actual
    public static int currentUserIdUsuario = 0;//Id_usuario del usuario actual

    public static String currentUser;
    public static String currentUserName;
    public static String currentPacienteName;

    public static int currentTest = 0;

    public static Boolean disable = false;

    public static String LEE;
    public static String PROLEC;
    public static String BENDER;
    public static String TEPSI;
    public static String PRECALCULO;
    public static String PROCALCULO;

    //Constantes Campo Persona
    public static String TABLA_PERSONA = "persona";
    public static String CAMPO_ID_PERSONA = "id_persona";
    public static String CAMPO_NOMBRE_PERSONA = "nombre_persona";
    public static String CAMPO_APELLIDO_PERSONA = "apellido_persona";
    public static String CAMPO_FECHA_NACIMIENTO_PERSONA = "fecha_nacimiento_persona";
    public static String CAMPO_IMAGEN_PERSONA = "imagen_persona";
    public static String CAMPO_TIPO_PERSONA = "tipo_persona";
    public static String CAMPO_UP_PERSONA = "up_persona";

    //Constantes Campo Pacientes
    public static String TABLA_PACIENTE = "paciente";
    public static String CAMPO_ID_PACIENTE = "id_paciente";
    public static String CAMPO_MOTIVO_CONSULTA_PACIENTE = "motivo_consulta_paciente";
    public static String CAMPO_ANTECEDENTES_PACIENTE = "antecedentes_paciente";

    //Constantes Campo Usuario
    public static String TABLA_USUARIO = "usuario";
    public static String CAMPO_ID_USUARIO = "id_usuario";
    public static String CAMPO_NOMBRE_USUARIO = "nombre_usuario";
    public static String CAMPO_EMAIL_USUARIO = "email_usuario";
    public static String CAMPO_CONTRASENA_USUARIO = "contrasena_usuario";

    //Constantes Campo Puntuaciones
    public static String TABLA_PUNTUACIONES_CC = "puntuacion_cc";
    public static String CAMPO_ID_PUNTUACION_CC = "id_puntuacion_cc";
    public static String CAMPO_CC = "campo_cc"; //CC1
    public static String CAMPO_CCS = "campo_ccs"; //CC2
    public static String CAMPO_UP_CC = "campo_up_cc"; //CC2

    public static String TABLA_PUNTUACIONES_S = "puntuacion_s";
    public static String CAMPO_ID_PUNTUACION_S = "id_puntuacion_s";
    public static String CAMPO_S = "campo_s";
    public static String CAMPO_UP_S = "campo_up_s";

    public static String TABLA_PUNTUACIONES_RD = "puntuacion_rd";
    public static String CAMPO_ID_PUNTUACION_RD = "id_puntuacion_rd";
    public static String CAMPO_RDD = "campo_rdd";
    public static String CAMPO_RDI = "campo_rdi";
    public static String CAMPO_RDT = "campo_rdt";
    public static String CAMPO_UP_RD = "campo_up_rd";

    public static String TABLA_PUNTUACIONES_CO = "puntuacion_co";
    public static String CAMPO_ID_PUNTUACION_CO = "id_puntuacion_co";
    public static String CAMPO_CO = "puntuacion_co";
    public static String CAMPO_UP_CO = "campo_up_co";

    public static String TABLA_PUNTUACIONES_CL = "puntuacion_cl";
    public static String CAMPO_ID_PUNTUACION_CL = "id_puntuacion_cl";
    public static String CAMPO_CL = "campo_cl";
    public static String CAMPO_UP_CL = "campo_up_cl";

    public static String TABLA_PUNTUACIONES_V = "puntuacion_v";
    public static String CAMPO_ID_PUNTUACION_V = "id_puntuacion_v";
    public static String CAMPO_V = "campo_v";
    public static String CAMPO_UP_V = "campo_up_v";

    public static String TABLA_PUNTUACIONES_LN = "puntuacion_ln";
    public static String CAMPO_ID_PUNTUACION_LN = "id_puntuacion_ln";
    public static String CAMPO_LN = "campo_ln";
    public static String CAMPO_UP_LN = "campo_up_ln";

    public static String TABLA_PUNTUACIONES_M = "puntuacion_m";
    public static String CAMPO_ID_PUNTUACION_M = "id_puntuacion_m";
    public static String CAMPO_M = "campo_m";
    public static String CAMPO_UP_M = "campo_up_m";

    public static String TABLA_PUNTUACIONES_C = "puntuacion_c";
    public static String CAMPO_ID_PUNTUACION_C = "id_puntuacion_c";
    public static String CAMPO_C = "campo_c";
    public static String CAMPO_UP_C = "campo_up_c";

    public static String TABLA_PUNTUACIONES_BS = "puntuacion_bs";
    public static String CAMPO_ID_PUNTUACION_BS = "id_puntuacion_bs";
    public static String CAMPO_BS = "campo_bs";
    public static String CAMPO_UP_BS = "campo_up_bs";

    public static String TABLA_PUNTUACIONES_CF = "puntuacion_cf";
    public static String CAMPO_ID_PUNTUACION_CF = "id_puntuacion_cf";
    public static String CAMPO_CF = "campo_cf";
    public static String CAMPO_UP_CF = "campo_up_cf";

    public static String TABLA_PUNTUACIONES_A = "puntuacion_a";
    public static String CAMPO_ID_PUNTUACION_A = "id_puntuacion_a";
    public static String CAMPO_A = "campo_a";
    public static String CAMPO_UP_A = "campo_up_a";

    public static String TABLA_PUNTUACIONES_I = "puntuacion_i";
    public static String CAMPO_ID_PUNTUACION_I = "id_puntuacion_i";
    public static String CAMPO_I = "campo_i";
    public static String CAMPO_UP_I = "campo_up_i";

    public static String TABLA_PUNTUACIONES_AR = "puntuacion_ar";
    public static String CAMPO_ID_PUNTUACION_AR = "id_puntuacion_ar";
    public static String CAMPO_AR = "campo_ar";
    public static String CAMPO_UP_AR = "campo_up_ar";

    public static String TABLA_PUNTUACIONES_AD = "puntuacion_ad";
    public static String CAMPO_ID_PUNTUACION_AD = "id_puntuacion_ad";
    public static String CAMPO_AD = "campo_ad";
    public static String CAMPO_UP_AD = "campo_up_ad";

    //Constantes tabla 1

    public static String TABLA_ESCALAR = "escalar";
    public static String CAMPO_ID_ESCALAR = "id_escalar";
    public static String CAMPO_ICV = "campo_icv";
    public static String CAMPO_IRP = "campo_irp";
    public static String CAMPO_IMO = "campo_imo";
    public static String CAMPO_IVP = "campo_ivp";
    public static String CAMPO_CIT = "campo_cit";


    //Constantes Tabla Test
    public static final String TABLA_TEST = "test";
    public static final String CAMPO_ID_TEST = "id_test";
    public static final String CAMPO_FECHA_TEST = "fecha_test";
    public static final String CAMPO_EVALUADOR_TEST = "evaluador_test";
    public static final String CAMPO_ESTADO_TEST = "estado_test";
    public static final String CAMPO_EDAD_TEST = "edad_test";
    public static final String CAMPO_INTERVALO = "campo_intervalo";
    public static final String CAMPO_UP_TEST = "campo_up_test";


    ///////////////////////////////////////////
    //********CREACIÓN DE TABLAS***************
    ///////////////////////////////////////////


    public static final String CREAR_TABLA_PUNTUACIONES_CC = "CREATE TABLE " + TABLA_PUNTUACIONES_CC +
            "(" +
            CAMPO_ID_PUNTUACION_CC + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_CC + " TEXT, " +
            CAMPO_CCS + " TEXT, " +
            CAMPO_UP_CC + "TEXT, "+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_S = "CREATE TABLE " + TABLA_PUNTUACIONES_S +
            "(" +
            CAMPO_ID_PUNTUACION_S + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_S + " TEXT,"+
            CAMPO_UP_S + "TEXT, "+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_RD = "CREATE TABLE " + TABLA_PUNTUACIONES_RD +
            "(" +
            CAMPO_ID_PUNTUACION_RD + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_RDD + " TEXT, " +
            CAMPO_RDI + " TEXT, " +
            CAMPO_RDT + " TEXT , "+
            CAMPO_UP_RD + "TEXT, "+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_CO = "CREATE TABLE " + TABLA_PUNTUACIONES_CO +
            "(" +
            CAMPO_ID_PUNTUACION_CO + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_CO + " TEXT, "+
            CAMPO_UP_CO + "TEXT, "+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_CL = "CREATE TABLE " + TABLA_PUNTUACIONES_CL +
            "(" +
            CAMPO_ID_PUNTUACION_CL + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_CL + " TEXT,"+
            CAMPO_UP_CL + "TEXT, "+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_V = "CREATE TABLE " + TABLA_PUNTUACIONES_V +
            "(" +
            CAMPO_ID_PUNTUACION_V + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_V + " TEXT,"+
            CAMPO_UP_V + "TEXT, "+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_LN = "CREATE TABLE " + TABLA_PUNTUACIONES_LN +
            "(" +
            CAMPO_ID_PUNTUACION_LN + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_LN + " TEXT,"+
            CAMPO_UP_LN + "TEXT, "+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_M = "CREATE TABLE " + TABLA_PUNTUACIONES_M +
            "(" +
            CAMPO_ID_PUNTUACION_M + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_M + " TEXT,"+
            CAMPO_UP_M + "TEXT, "+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_C = "CREATE TABLE " + TABLA_PUNTUACIONES_C +
            "(" +
            CAMPO_ID_PUNTUACION_C + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_C + " TEXT,"+
            CAMPO_UP_C + "TEXT, "+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_BS = "CREATE TABLE " + TABLA_PUNTUACIONES_BS +
            "(" +
            CAMPO_ID_PUNTUACION_BS + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_BS + " TEXT,"+
            CAMPO_UP_BS + "TEXT, "+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_CF = "CREATE TABLE " + TABLA_PUNTUACIONES_CF +
            "(" +
            CAMPO_ID_PUNTUACION_CF + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_CF + " TEXT,"+
            CAMPO_UP_CF + "TEXT, "+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_A = "CREATE TABLE " + TABLA_PUNTUACIONES_A +
            "(" +
            CAMPO_ID_PUNTUACION_A + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_A + " TEXT,"+
            CAMPO_UP_A + "TEXT, "+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_I = "CREATE TABLE " + TABLA_PUNTUACIONES_I +
            "(" +
            CAMPO_ID_PUNTUACION_I + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_I + " TEXT,"+
            CAMPO_UP_I + "TEXT, "+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_AR = "CREATE TABLE " + TABLA_PUNTUACIONES_AR +
            "(" +
            CAMPO_ID_PUNTUACION_AR + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_AR + " TEXT,"+
            CAMPO_UP_AR + "TEXT, "+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_AD = "CREATE TABLE " + TABLA_PUNTUACIONES_AD +
            "(" +
            CAMPO_ID_PUNTUACION_AD + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_AD + " TEXT,"+
            CAMPO_UP_AD + "TEXT, "+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_TEST = "CREATE TABLE " + TABLA_TEST +
            " (" +
            CAMPO_ID_TEST + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_FECHA_TEST + " TEXT, " +
            CAMPO_EVALUADOR_TEST + " TEXT, " +
            CAMPO_ESTADO_TEST + " TEXT, " +
            CAMPO_INTERVALO+ " TEXT, " +
            CAMPO_EDAD_TEST+ " TEXT, " +
            CAMPO_UP_TEST+ " TEXT, " +
            CAMPO_ID_PACIENTE + " INTEGER)";


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
            CAMPO_UP_PERSONA + " TEXT, "+
            CAMPO_TIPO_PERSONA + " TEXT )";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE " + TABLA_USUARIO +
            " (" +
            CAMPO_ID_USUARIO + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_NOMBRE_USUARIO + " TEXT, " +
            CAMPO_EMAIL_USUARIO + " TEXT, " +
            CAMPO_CONTRASENA_USUARIO + " TEXT," +
            CAMPO_ID_PERSONA+" INTEGER"+
            ")";


    public static final String CREAR_TABLA_ESCALAR = "CREATE TABLE " + TABLA_ESCALAR +
            "(" +
            CAMPO_ID_ESCALAR + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_ICV + " TEXT, " +
            CAMPO_IRP + " TEXT, " +
            CAMPO_IMO + " TEXT, " +
            CAMPO_IVP + " TEXT, " +
            CAMPO_CIT + " TEXT ) ";

}
