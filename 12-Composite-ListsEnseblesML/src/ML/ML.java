package ML;

import ML.Models.Composite;
import ML.Models.Ensemble;
import ML.Models.Model;

/**
 * Тут инициализируются модели весами
 */
public class ML {
  /**
   * Метод для инициализации
   *
   * @return Главный ансамблю
   */
  public Composite getAllComposite() {
    // Создание моделей
    Composite model01 = new Model(-102.49471949660837,-8.89188746 ,1.06867566);
    Composite model02 = new Model(-101.72736400526504,-8.83635603 ,1.06429466);
    Composite model03 = new Model(-101.91704857584745,-8.77785619 ,1.06504784);
    Composite model04 = new Model(-101.77853945339041,-8.84484014 ,1.06412833);
    Composite model05 = new Model(-101.72885935568668,-8.81298505 ,1.06422145);
    Composite model06 = new Model(-100.01460670968561,-9.08389808 ,1.05446846);
    Composite model07 = new Model(-101.77362325875811,-8.73931528 ,1.06360157);
    Composite model08 = new Model(-102.37489839616858,-8.68686207 ,1.06762342);
    Composite model09 = new Model(-102.79084623072842,-8.85387835 ,1.07021449);
    Composite model10 = new Model(-101.34762114545767,-8.88384337 ,1.06168387);
    Composite model11 = new Model(-101.45889562205043,-8.83487284 ,1.06268468);
    Composite model12 = new Model(-101.59138233909188,-8.86906704 ,1.06291973);
    Composite model13 = new Model(-102.15280482433262,-9.01563371 ,1.06701443);
    Composite model14 = new Model(-104.16352441437799,-8.68310898 ,1.07800615);
    Composite model15 = new Model(-101.41904173607695,-8.83419365 ,1.06221435);
    Composite model16 = new Model(-101.63604242549843,-8.70075086 ,1.06283334);
    Composite model17 = new Model(-103.18291417903885,-8.68729993 ,1.07204568);
    Composite model18 = new Model(-100.93782662183368,-8.90710301 ,1.05930103);
    Composite model19 = new Model(-102.72711137908857,-8.72343833 ,1.06968906);
    Composite model20 = new Model(-102.46990353809777,-8.84017537 ,1.06831835);
    Composite model21 = new Model(-101.70681061288462,-8.84617739 ,1.06377469);
    Composite model22 = new Model(-101.08224799077948,-8.97238678 ,1.06026595);
    Composite model23 = new Model(-103.12778758579071,-8.64989783 ,1.07157015);
    Composite model24 = new Model(-102.34993897853782,-8.73863182 ,1.06739025);
    Composite model25 = new Model(-102.57617756258756,-8.86461346 ,1.06899151);
    Composite model26 = new Model(-101.90530553380809,-8.83965089 ,1.06533928);
    Composite model27 = new Model(-103.32281151584532,-8.68203011 ,1.07290231);
    Composite model28 = new Model(-102.90585775869033,-8.78090954 ,1.07071868);
    Composite model29 = new Model(-102.87194144484967,-8.62175133 ,1.07040034);
    Composite model30 = new Model(-102.05587088681322,-8.80710396 ,1.06584497);
    Composite model31 = new Model(-103.33294870662894,-8.75312111 ,1.07331785);
    Composite model32 = new Model(-101.27241236303352,-8.92984888 ,1.06108002);
    Composite model33 = new Model(-102.78469681609174,-8.74673568 ,1.07018296);
    Composite model34 = new Model(-101.53703088340434,-8.69743512 ,1.06247297);
    Composite model35 = new Model(-102.78017182779188,-8.83973047 ,1.07002537);
    Composite model36 = new Model(-102.78840048258506,-8.74716189 ,1.06964668);
    Composite model37 = new Model(-101.35089040091965,-8.97540208 ,1.06195372);
    Composite model38 = new Model(-102.22953472359409,-8.83776059 ,1.06694665);
    Composite model39 = new Model(-101.58047488592709,-8.88237857 ,1.06314934);
    Composite model40 = new Model(-104.83942107212293,-8.66206104 ,1.08167513);
    Composite model41 = new Model(-103.86796619145578,-8.63340503 ,1.07657039);
    Composite model42 = new Model(-100.46130349218059,-8.84382495 ,1.05680843);
    Composite model43 = new Model(-100.99047257910571,-8.86790631 ,1.05975546);
    Composite model44 = new Model(-103.37027570219338,-8.76687914 ,1.07336308);
    Composite model45 = new Model(-102.39285753675486,-8.63499533 ,1.06713051);
    Composite model46 = new Model(-103.36880974684824,-8.91556684 ,1.07393987);
    Composite model47 = new Model(-102.42233951767959,-8.71247382 ,1.06754821);
    Composite model48 = new Model(-102.13046157486889,-8.68364522 ,1.06593592);
    Composite model49 = new Model(-101.46032356078244,-8.79373293 ,1.06237008);
    Composite model50 = new Model(-103.46253310613501,-8.59170472 ,1.07383457);
    Composite model51 = new Model(-101.82933418852389,-8.86142362 ,1.06448729);
    Composite model52 = new Model(-102.23434815264183,-8.70872395 ,1.06665692);
    Composite model53 = new Model(-102.51076892484382,-8.80649738 ,1.06866596);
    Composite model54 = new Model(-100.45255619626319,-8.85823859 ,1.05680108);
    Composite model55 = new Model(-103.77130170176987,-8.72458432 ,1.07567157);
    Composite model56 = new Model(-105.33513928435006,-8.48945203 ,1.08447484);
    Composite model57 = new Model(-104.36490650488341,-8.80081537 ,1.07908039);
    Composite model58 = new Model(-101.36332183191517,-8.92251083 ,1.06247309);
    Composite model59 = new Model(-103.51732253581804,-8.73013057 ,1.07411887);
    Composite model60 = new Model(-102.35000476005868,-8.82887317 ,1.06729435);
    Composite model61 = new Model(-102.86513728806105,-8.74615632 ,1.07011151);
    Composite model62 = new Model(-102.22788884602852,-8.80608682 ,1.06667565);
    Composite model63 = new Model(-100.61420327322341,-8.97777929 ,1.05808893);
    Composite model64 = new Model(-102.80287910973536,-8.83724706 ,1.07046995);
    Composite model65 = new Model(-102.94163982783363,-8.53399621 ,1.07054957);
    Composite model66 = new Model(-101.82212102266655,-8.70452971 ,1.06442974);

    // Создание под-ансамблей
    Composite ensemble01 = new Ensemble();
    Composite ensemble02 = new Ensemble();
    Composite ensemble03 = new Ensemble();
    Composite ensemble04 = new Ensemble();
    Composite ensemble05 = new Ensemble();
    Composite ensemble06 = new Ensemble();

    // Создание главного ансамбля
    Composite ensembleAll = new Ensemble();

    // Добавляю модели в под-ансамбли
    ensemble01.add(model01);
    ensemble01.add(model02);
    ensemble01.add(model03);
    ensemble01.add(model04);
    ensemble01.add(model05);
    ensemble01.add(model06);
    ensemble01.add(model07);
    ensemble01.add(model08);
    ensemble01.add(model09);
    ensemble01.add(model10);

    ensemble02.add(model11);
    ensemble02.add(model12);
    ensemble02.add(model13);
    ensemble02.add(model14);
    ensemble02.add(model15);
    ensemble02.add(model16);
    ensemble02.add(model17);
    ensemble02.add(model18);
    ensemble02.add(model19);
    ensemble02.add(model20);

    ensemble03.add(model21);
    ensemble03.add(model22);
    ensemble03.add(model23);
    ensemble03.add(model24);
    ensemble03.add(model25);
    ensemble03.add(model26);
    ensemble03.add(model27);
    ensemble03.add(model28);
    ensemble03.add(model29);
    ensemble03.add(model30);

    ensemble04.add(model31);
    ensemble04.add(model32);
    ensemble04.add(model33);
    ensemble04.add(model34);
    ensemble04.add(model35);
    ensemble04.add(model36);
    ensemble04.add(model37);
    ensemble04.add(model38);
    ensemble04.add(model39);
    ensemble04.add(model40);

    ensemble05.add(model41);
    ensemble05.add(model42);
    ensemble05.add(model43);
    ensemble05.add(model44);
    ensemble05.add(model45);
    ensemble05.add(model46);
    ensemble05.add(model47);
    ensemble05.add(model48);
    ensemble05.add(model49);
    ensemble05.add(model50);

    ensemble06.add(model51);
    ensemble06.add(model52);
    ensemble06.add(model53);
    ensemble06.add(model54);
    ensemble06.add(model55);
    ensemble06.add(model56);
    ensemble06.add(model57);
    ensemble06.add(model58);
    ensemble06.add(model59);
    ensemble06.add(model60);

    // Добавляю под-ансамбли в главный ансамбль
    ensembleAll.add(ensemble01);
    ensembleAll.add(ensemble02);
    ensembleAll.add(ensemble03);
    ensembleAll.add(ensemble04);
    ensembleAll.add(ensemble05);
    ensembleAll.add(ensemble06);

    // Добавляю оставшиеся модели в главный ансамбль
    ensembleAll.add(model61);
    ensembleAll.add(model62);
    ensembleAll.add(model63);
    ensembleAll.add(model64);
    ensembleAll.add(model65);
    ensembleAll.add(model66);

    return ensembleAll;
  }
}
