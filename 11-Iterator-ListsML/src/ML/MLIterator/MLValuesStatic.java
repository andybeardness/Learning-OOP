package ML.MLIterator;

/**
 * Класс со статическими значениями для моделей
 *    -- BList -- список байесов
 *    -- GenderList -- список коэффициентов для гендера
 *    -- HeightList -- список коэффициентов для ростов
 *
 *    -- One -- для ArrayList реализцаии
 *    -- Two -- для LinkedList реализации
 */
public class MLValuesStatic {
  public static double[] getBListOne() {
    return new double[] {
      -99.3505324588839,
      -102.216801441562,
      -101.369100927506,
      -101.002808754351,
      -103.773968110739,
      -102.916380928705,
      -101.486421609291,
      -101.920675703236,
      -99.2414965610396,
      -103.332916224124,
    };
  }

  public static double[] getBListTwo() {
    return new double[] {
      -101.5410148955846,
      -102.6110218625772,
      -101.3276419548746,
      -103.5268762583557,
      -100.8536423437616,
      -103.0577476769252,
      -102.6363854671136,
      -101.7115073766596,
      -101.1591972340598,
      -102.0152285609503,
    };
  }

  public static double[] getGenderListOne() {
    return new double[] {
      -9.0542010,
      -8.8409314,
      -8.9585946,
      -9.0269307,
      -8.6885953,
      -8.6026843,
      -8.8225424,
      -8.7772795,
      -9.0267673,
      -8.7305782,

    };
  }

  public static double[] getGenderListTwo() {
    return new double[] {
      -8.7685687,
      -8.7096243,
      -8.8090250,
      -8.5772374,
      -8.9071911,
      -8.8088426,
      -8.9363421,
      -8.8472490,
      -9.0155637,
      -8.8010460,
    };
  }

  public static double[] getHeightListOne() {
    return new double[] {
        1.050862,
        1.066823,
        1.062146,
        1.060084,
        1.075543,
        1.070123,
        1.062363,
        1.064883,
        1.050100,
        1.073502,
    };
  }

  public static double[] getHeightListTwo() {
    return new double[] {
        1.062918,
        1.068715,
        1.061286,
        1.073942,
        1.059302,
        1.072259,
        1.070045,
        1.063690,
        1.061348,
        1.065859,
    };
  }
}
