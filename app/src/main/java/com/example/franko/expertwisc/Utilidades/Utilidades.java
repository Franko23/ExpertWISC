package com.example.franko.expertwisc.Utilidades;

import java.util.List;

/**
 * Created by FRANKO on 14/11/2017.
 */

public class Utilidades {
    //Variable de PageViewer
    public static int rotacionG = 0;
    public static int rotacionR = 0;
    public static int rotacionFab = 0;

    public static String edadActual = "Sin Edad"; //Edad del paciente actual
    public static String fechaNacimiento= "Sin Fecha"; //Edad del paciente actual
    public static String fechaEvaluacion; //Fecha de evaluación
    public static String antecedentes = ""; //Fecha de evaluación
    public static String motivo = ""; //Fecha de evaluación
    public static String Sugerencias = "No hay sugerencias para este caso"; //Fecha de evaluación
    public static String Conclusiones  = "No hay conclusiones para este caso"; //Fecha de evaluación
    public static String Sugerencias_key = "No hay sugerencias para este caso"; //Fecha de evaluación
    public static String Conclusiones_key  = "No hay conclusiones para este caso"; //Fecha de evaluación


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
    public static String currentUserFreeUsuario = "";
    public static int currentCounterPatients = 0;

    public static String currentUser;
    public static String currentUserName;
    public static String currentPacienteName;

    public static int currentTest = 0;
    public static int currentCC = 0;
    public static int currentS = 0;
    public static int currentRD = 0;
    public static int currentCo = 0;
    public static int currentCl = 0;
    public static int currentV = 0;
    public static int currentLN = 0;
    public static int currentM = 0;
    public static int currentC = 0;
    public static int currentBS = 0;
    public static int currentCF= 0;
    public static int currentA = 0;
    public static int currentI = 0;
    public static int currentAr = 0;
    public static int currentAd = 0;

    public static int TestUp = 0;

    public static Boolean disable = false;

    public static String LEE;
    public static String PROLEC;
    public static String BENDER;
    public static String TEPSI;
    public static String PRECALCULO;
    public static String PROCALCULO;
    public static String RAVEN_G;

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
    public static String CAMPO_FREE_USUARIO = "free_usuario";

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


    //Constantes Tabla Test
    public static String TABLA_TEST = "test";
    public static String CAMPO_ID_TEST = "id_test";
    public static String CAMPO_FECHA_TEST = "fecha_test";
    public static String CAMPO_EVALUADOR_TEST = "evaluador_test";
    public static String CAMPO_ESTADO_TEST = "estado_test";
    public static String CAMPO_EDAD_TEST = "edad_test";
    public static String CAMPO_INTERVALO = "campo_intervalo";
    public static String CAMPO_UP_TEST = "campo_up_test";


    //Constantes de la Base de Conocimiento - TABLA ICV
    public static String TABLA_ICV = "icv";
    public static String CAMPO_ID_ICV = "id_icv";
    public static String CAMPO_EDAD_ICV = "edad_icv";
    public static String CAMPO_SUGERENCIAS_KEY_ICV = "sugerencias_key_icv";
    public static String CAMPO_MOTIVO_ICV = "motivo_icv";
    public static String CAMPO_ANTECEDENTES_ICV = "antecedentes_icv";
    public static String CAMPO_SUGERENCIAS_ICV = "sugerencias_icv";
    public static String CAMPO_CONCLUSIONES_KEY_ICV = "conclusiones_key_icv";
    public static String CAMPO_CONCLUSIONES_ICV = "conclusiones_icv";

    //Constantes de la Base de Conocimiento - TABLA IRP
    public static String TABLA_IRP = "irp";
    public static String CAMPO_ID_IRP = "id_irp";
    public static String CAMPO_EDAD_IRP = "edad_irp";
    public static String CAMPO_SUGERENCIAS_KEY_IRP = "sugerencias_key_irp";
    public static String CAMPO_MOTIVO_IRP = "motivo_irp";
    public static String CAMPO_ANTECEDENTES_IRP = "antecedentes_irp";
    public static String CAMPO_SUGERENCIAS_IRP = "sugerencias_irp";
    public static String CAMPO_CONCLUSIONES_KEY_IRP = "conclusiones_key_irp";
    public static String CAMPO_CONCLUSIONES_IRP = "conclusiones_irp";

    //Constantes de la Base de Conocimiento - TABLA IMO
    public static String TABLA_IMO = "imo";
    public static String CAMPO_ID_IMO = "id_imo";
    public static String CAMPO_EDAD_IMO = "edad_imo";
    public static String CAMPO_MOTIVO_IMO = "motivo_imo";
    public static String CAMPO_ANTECEDENTES_IMO = "antecedentes_imo";
    public static String CAMPO_SUGERENCIAS_IMO = "sugerencias_imo";
    public static String CAMPO_CONCLUSIONES_IMO = "conclusiones_imo";
    public static String CAMPO_SUGERENCIAS_KEY_IMO = "sugerencias_key_imo";
    public static String CAMPO_CONCLUSIONES_KEY_IMO = "conclusiones_key_imo";

    //Constantes de la Base de Conocimiento - TABLA IVP
    public static String TABLA_IVP = "ivp";
    public static String CAMPO_ID_IVP = "id_ivp";
    public static String CAMPO_EDAD_IVP = "edad_ivp";
    public static String CAMPO_MOTIVO_IVP = "motivo_ivp";
    public static String CAMPO_ANTECEDENTES_IVP = "antecedentes_ivp";
    public static String CAMPO_SUGERENCIAS_KEY_IVP = "sugerencias_key_ivp";
    public static String CAMPO_CONCLUSIONES_KEY_IVP = "conclusiones_key_ivp";
    public static String CAMPO_SUGERENCIAS_IVP = "sugerencias_ivp";
    public static String CAMPO_CONCLUSIONES_IVP = "conclusiones_ivp";


    ///////////////////////////////////////////
    //********CREACIÓN DE TABLAS*************//
    ///////////////////////////////////////////


    public static final String CREAR_TABLA_PUNTUACIONES_CC = "CREATE TABLE " + TABLA_PUNTUACIONES_CC +
            "(" +
            CAMPO_ID_PUNTUACION_CC + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_CC + " TEXT, " +
            CAMPO_CCS + " TEXT, " +
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_S = "CREATE TABLE " + TABLA_PUNTUACIONES_S +
            "(" +
            CAMPO_ID_PUNTUACION_S + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_S + " TEXT,"+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_RD = "CREATE TABLE " + TABLA_PUNTUACIONES_RD +
            "(" +
            CAMPO_ID_PUNTUACION_RD + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_RDD + " TEXT, " +
            CAMPO_RDI + " TEXT, " +
            CAMPO_RDT + " TEXT , "+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_CO = "CREATE TABLE " + TABLA_PUNTUACIONES_CO +
            "(" +
            CAMPO_ID_PUNTUACION_CO + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_CO + " TEXT, "+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_CL = "CREATE TABLE " + TABLA_PUNTUACIONES_CL +
            "(" +
            CAMPO_ID_PUNTUACION_CL + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_CL + " TEXT,"+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_V = "CREATE TABLE " + TABLA_PUNTUACIONES_V +
            "(" +
            CAMPO_ID_PUNTUACION_V + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_V + " TEXT,"+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_LN = "CREATE TABLE " + TABLA_PUNTUACIONES_LN +
            "(" +
            CAMPO_ID_PUNTUACION_LN + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_LN + " TEXT,"+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_M = "CREATE TABLE " + TABLA_PUNTUACIONES_M +
            "(" +
            CAMPO_ID_PUNTUACION_M + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_M + " TEXT,"+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_C = "CREATE TABLE " + TABLA_PUNTUACIONES_C +
            "(" +
            CAMPO_ID_PUNTUACION_C + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_C + " TEXT,"+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_BS = "CREATE TABLE " + TABLA_PUNTUACIONES_BS +
            "(" +
            CAMPO_ID_PUNTUACION_BS + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_BS + " TEXT,"+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_CF = "CREATE TABLE " + TABLA_PUNTUACIONES_CF +
            "(" +
            CAMPO_ID_PUNTUACION_CF + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_CF + " TEXT,"+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_A = "CREATE TABLE " + TABLA_PUNTUACIONES_A +
            "(" +
            CAMPO_ID_PUNTUACION_A + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_A + " TEXT,"+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_I = "CREATE TABLE " + TABLA_PUNTUACIONES_I +
            "(" +
            CAMPO_ID_PUNTUACION_I + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_I + " TEXT,"+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_AR = "CREATE TABLE " + TABLA_PUNTUACIONES_AR +
            "(" +
            CAMPO_ID_PUNTUACION_AR + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_AR + " TEXT,"+
            CAMPO_ID_TEST + " INTEGER ) ";

    public static final String CREAR_TABLA_PUNTUACIONES_AD = "CREATE TABLE " + TABLA_PUNTUACIONES_AD +
            "(" +
            CAMPO_ID_PUNTUACION_AD + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_AD + " TEXT,"+
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
            CAMPO_ID_PERSONA+" INTEGER,"+
            CAMPO_FREE_USUARIO +" TEXT )";

    //TABLAS BASE DE CONOCIMIENTO
    public static final String CREAR_TABLA_ICV = "CREATE TABLE " + TABLA_ICV +
            " (" +
            CAMPO_ID_ICV + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_EDAD_ICV + " TEXT, " +
            CAMPO_MOTIVO_ICV + " TEXT," +
            CAMPO_ANTECEDENTES_ICV +" TEXT, "+
            CAMPO_SUGERENCIAS_KEY_ICV +" TEXT, "+
            CAMPO_SUGERENCIAS_ICV +" TEXT, "+
            CAMPO_CONCLUSIONES_KEY_ICV +" TEXT, "+
            CAMPO_CONCLUSIONES_ICV +" TEXT )";

    public static final String CREAR_TABLA_IRP = "CREATE TABLE " + TABLA_IRP +
            " (" +
            CAMPO_ID_IRP + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_EDAD_IRP + " TEXT, " +
            CAMPO_MOTIVO_IRP + " TEXT," +
            CAMPO_ANTECEDENTES_IRP +" TEXT, "+
            CAMPO_SUGERENCIAS_KEY_IRP +" TEXT, "+
            CAMPO_SUGERENCIAS_IRP +" TEXT, "+
            CAMPO_CONCLUSIONES_KEY_IRP +" TEXT, "+
            CAMPO_CONCLUSIONES_IRP +" TEXT )";

    public static final String CREAR_TABLA_IMO = "CREATE TABLE " + TABLA_IMO +
            " (" +
            CAMPO_ID_IMO + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_EDAD_IMO + " TEXT, " +
            CAMPO_MOTIVO_IMO + " TEXT," +
            CAMPO_ANTECEDENTES_IMO +" TEXT, "+
            CAMPO_SUGERENCIAS_KEY_IMO +" TEXT, "+
            CAMPO_SUGERENCIAS_IMO +" TEXT, "+
            CAMPO_CONCLUSIONES_KEY_IMO +" TEXT, "+
            CAMPO_CONCLUSIONES_IMO +" TEXT )";

    public static final String CREAR_TABLA_IVP = "CREATE TABLE " + TABLA_IVP +
            " (" +
            CAMPO_ID_IVP + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            CAMPO_EDAD_IVP + " TEXT, " +
            CAMPO_MOTIVO_IVP + " TEXT," +
            CAMPO_ANTECEDENTES_IVP +" TEXT, "+
            CAMPO_SUGERENCIAS_KEY_IVP +" TEXT, "+
            CAMPO_SUGERENCIAS_IVP +" TEXT, "+
            CAMPO_CONCLUSIONES_KEY_IVP +" TEXT, "+
            CAMPO_CONCLUSIONES_IVP +" TEXT )";

}
