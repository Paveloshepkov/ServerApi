package ru.novosoft.generators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.novosoft.model.Person;
import ru.novosoft.model.MertEquipModel.Composition;
import ru.novosoft.model.MertEquipModel.EtalonRegNo;
import ru.novosoft.model.MertEquipModel.GeneralInfo;
import ru.novosoft.model.MertEquipModel.MeasurementParam;
import ru.novosoft.model.MertEquipModel.OperationalInfo;
import ru.novosoft.model.MertEquipModel.Wo;
import ru.novosoft.model.MertEquipModel.WoMtlg;
import ru.novosoft.model.MetrEquipItemModel;
import ru.novosoft.model.Tasks;
import org.springframework.stereotype.Component;

@Component
public class Generator {
	private final List<Person> people;

	public Generator() {
		people = new ArrayList<>();
		Person admin = new Person("admin", "1", "ROLE_ADMIN", tasksGenerator(),  equipmentGenerator());
		Person person = new Person("user", "1", "ROLE_USER", tasksGenerator(), equipmentGenerator());
		people.add(admin);
		people.add(person);

	}

	public List<Person> getUsers() {
		return people;
	}

	public Person findUser(String login, String password) {
		for (Person person : people) {
			if (person.getUsername().equals(login) && person.getPassword().equals(password)) {
				return person;
			}
		}
		return null;
	}


	public Person loadUserByUsername(String username) throws UsernameNotFoundException {
		for (Person person : people) {
			if (person.getUsername().equals(username)) {
				return person;
			}
		}
		throw new UsernameNotFoundException("User not found with username: " + username);
	}

	public List<Tasks> getUserTasks(Person person) {
		return person.getTasksList();
	}

	public List<MetrEquipItemModel> getUserEquipment(Person person) {
		return person.getEquipmentList();
	}

	private List<MetrEquipItemModel> equipmentGenerator() {
		List<MetrEquipItemModel> metrEquipModels = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			GeneralInfo generalInfo = generateRandomGeneralInfo();
			OperationalInfo operationalInfo = generateRandomOperationalInfo();
			List<MeasurementParam> measurementParams = generateRandomMeasurementParam();
			List<Composition> compositions = generateRandomComposition();
			List<WoMtlg> woMtlgs = generateRandomWoMtlg();
			List<Wo> wo = generateRandomWo();

			MetrEquipItemModel metrEquipItemModel = new MetrEquipItemModel(
					generalInfo,
					operationalInfo,
					measurementParams,
					compositions,
					woMtlgs,
					wo
			);
			metrEquipModels.add(metrEquipItemModel);
		}
		return metrEquipModels;
	}

	private List<Tasks> tasksGenerator() {
		List<Tasks> tasksList = new ArrayList<>();
		String[] types = {
				"Выполнение метрологического надзора",
				"Согласование расконсервации",
				"Завершение работ"
		};
		Random random = new Random();
		for (int i = 1; i <= 10; i++) {
			String type = types[random.nextInt(types.length)];
			String time = generateRandomDateTime();
			Tasks taskModel = new Tasks(i, type, time);
			tasksList.add(taskModel);
		}
		return tasksList;
	}

	private String generateRandomDateTime() {
		int year = 2022;
		int month = (int) (Math.random() * 12);
		int day = (int) (Math.random() * 27) + 1; // День от 1 до 28
		int hour = (int) (Math.random() * 24);
		int minute = (int) (Math.random() * 60);

		return String.format("%02d.%02d.%d %02d:%02d", day, month + 1, year, hour, minute);
	}

	private GeneralInfo generateRandomGeneralInfo() {
		Random random = new Random();

		List<String> mtKinds = Arrays.asList(
				"Электронные компоненты",
				"Измерительное оборудование",
				"Электронные приборы",
				"Медицинское оборудование",
				"Автоматизированные системы"
		);
		String mtKind = mtKinds.get(random.nextInt(mtKinds.size()));

		List<String> mtNames = Arrays.asList(
				"Резисторы",
				"Частотомеры",
				"Осциллографы",
				"Электронные весы",
				"ЭКГ аппараты"
		);
		String mtName = mtNames.get(random.nextInt(mtNames.size()));

		List<String> mtModificationNames = Arrays.asList("Синий", "Красный", "Зеленый", "Желтый",
				"Черный");
		String mtModificationName = mtModificationNames.get(
				random.nextInt(mtModificationNames.size()));

		List<String> manufacturers = Arrays.asList(
				"Agilent Technologies",
				"Tektronix",
				"Fluke Corporation",
				"Keysight Technologies",
				"Rohde & Schwarz"
		);
		String manufacturer = manufacturers.get(random.nextInt(manufacturers.size()));
		int id = random.nextInt();

		return new GeneralInfo(
				id,
				Integer.toString(random.nextInt(10000)),
				"NS" + random.nextInt(100000),
				mtKind,
				mtName,
				"АКИП-4125С",
				"АКИП-4125С-А",
				mtModificationName,
				random.nextInt(100000) + "-" + random.nextInt(100),
				manufacturer,
				(random.nextInt(2025 - 2000) + 2000) + "-" + (random.nextInt(12) + 1) + "-" + (
						random.nextInt(28) + 1)
		);
	}

	private OperationalInfo generateRandomOperationalInfo() {
		Random random = new Random();

		List<String> assetStatusOptions = Arrays.asList(
				"В эксплуатации",
				"На ремонте",
				"В обменном фонде",
				"Списано"
		);
		String assetStatus = assetStatusOptions.get(random.nextInt(assetStatusOptions.size()));

		List<String> exploitObjectOptions = Arrays.asList(
				"АО «Норильскгазпром»/Служба метрологии",
				"ЗАО «Сибметрспецзолото»",
				"ГУП «Электросеть»",
				"Компания «Газпромнефть»"
		);
		String exploitObject = exploitObjectOptions.get(
				random.nextInt(exploitObjectOptions.size()));

		List<String> facilityNameOptions = Arrays.asList(
				"КПО ЦЭО\\АСУТП\\Бойлерная\\Т пара в коллекторе",
				"ТЭЦ-2\\Блок ТЭЦ-2 №1\\Пульт оператора",
				"ПХЭС №3\\ПТ №3.1\\Главный цеховой трансформатор"
		);
		String facilityName = facilityNameOptions.get(random.nextInt(facilityNameOptions.size()));

		List<String> mtAcctRespOptions = Arrays.asList(
				"Иванов А.С.",
				"Петров Б.И.",
				"Сидоров В.П.",
				"Козлов Г.М."
		);
		String mtAcctResp = mtAcctRespOptions.get(random.nextInt(mtAcctRespOptions.size()));

		List<String> assetUserOptions = Arrays.asList(
				"Иванов А.С.",
				"Петров Б.И.",
				"Сидоров В.П.",
				"Козлов Г.М."
		);
		String assetUser = assetUserOptions.get(random.nextInt(assetUserOptions.size()));

		List<EtalonRegNo> etalonRegNoList = Arrays.asList(
				new EtalonRegNo("16688.97.РЭ.00474110", false),
				new EtalonRegNo("16688.97.Р2.00474115", true)
		);

		String metrOperationType = Arrays.asList(
				"Эталонное",
				"Испытательное",
				"Сертификационное",
				"Калибровочное"
		).get(random.nextInt(4));

		String sgroeiCode = "Ст.1. п.5";

		String lastClosedWe = String.format(
				"%04d-%02d-%02d",
				random.nextInt(2025 - 2000) + 2000,
				random.nextInt(12) + 1,
				random.nextInt(28) + 1
		);

		return new OperationalInfo(
				assetStatus,
				random.nextBoolean(),
				exploitObject,
				"KG1B050050",
				facilityName,
				mtAcctResp,
				assetUser,
				metrOperationType,
				etalonRegNoList,
				random.nextBoolean(),
				random.nextBoolean(),
				sgroeiCode,
				lastClosedWe
		);
	}

	private List<MeasurementParam> generateRandomMeasurementParam() {
		Random random = new Random();
		List<MeasurementParam> measurementParams = new ArrayList<>();

		List<String> measurementKindCodes = Arrays.asList("30", "34", "40", "50", "60");

		List<String> measurementParamNames = Arrays.asList(
				"Избыточное давление", "Активное сопротивление", "Температура", "Влажность",
				"Давление"
		);

		List<Double> lowerLimits = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			lowerLimits.add(random.nextDouble() * 100);
		}

		List<String> lowerLimitUoms = Arrays.asList("кгс/см2", "кОм", "°C", "%", "мм рт. ст.");

		List<Double> upperLimits = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			upperLimits.add(100 + random.nextDouble() * 100);
		}

		List<String> upperLimitUoms = Arrays.asList("кгс/см2", "кОм", "°C", "%", "мм рт. ст.");

		List<Double> absoluteErrors = Arrays.asList(0.0, 0.1, 0.2, 0.5, 1.0, null);

		List<String> absoluteErrorUoms = Arrays.asList("кгс/см2", "кОм", "°C", "%", "мм рт. ст.",
				null);

		List<Double> relativeErrors = Arrays.asList(0.01, 0.02, 0.05, 0.1, 0.2, null);

		List<String> accuracyClasses = Arrays.asList("1.0", "1.5", "2.0", "2.5", null);

		for (int i = 0; i < 5; i++) {
			MeasurementParam measurementParam = new MeasurementParam(
					measurementKindCodes.get(random.nextInt(measurementKindCodes.size())),
					measurementParamNames.get(random.nextInt(measurementParamNames.size())),
					lowerLimits.get(i),
					lowerLimitUoms.get(random.nextInt(lowerLimitUoms.size())),
					upperLimits.get(i),
					upperLimitUoms.get(random.nextInt(upperLimitUoms.size())),
					absoluteErrors.get(random.nextInt(absoluteErrors.size())),
					absoluteErrorUoms.get(random.nextInt(absoluteErrorUoms.size())),
					relativeErrors.get(random.nextInt(relativeErrors.size())),
					accuracyClasses.get(random.nextInt(accuracyClasses.size()))
			);
			measurementParams.add(measurementParam);
		}

		return measurementParams;
	}

	private List<Composition> generateRandomComposition() {
		Random random = new Random();
		List<Composition> compositions = new ArrayList<>();

		List<String> mtTypes = Arrays.asList(
				"Клещи токоизмерительные; APPA A0, APPA A1, APPA A3AR, APPA A5AR, APPA A17, APPA A17R, APPA A18plus, APPA 133F, APPA 136F, APPA 137F, APPA 138F, APPA sFlex 10D, APPA sFlex 18D, APPA sFlex 10T, APPA sFlex 18T;  59659-15; Фирма \"APPA Technology Corporation\", Тайвань(Локальный)",
				"Мультиметры цифровые; APPA-17, APPA-17A, APPA-63N, APPA-67, APPA-69, APPA-97R, APPA-99II, APPA-201N, APPA-203, APPA-205, APPA-207; 21179-07; Фирма \"APPA Technology Corporation\", Тайвань(Локальный)",
				"Вольтметры; APPA 10, APPA 10R, APPA 11, APPA 15R, APPA 17, APPA 201N, APPA 203, APPA 205, APPA 206, APPA 207, APPA 207II; 21179-07; Фирма \"APPA Technology Corporation\", Тайвань(Локальный)",
				"Осциллографы; TDS1000B, TDS2000B, TDS1000C-EDU, TDS2000C-EDU; 020110174; Фирма \"Tektronix\", США",
				"Мультиметры; UT33D+, UT33D+EU, UT33C+, UT33C+EU; HY201109021; Фирма \"UNI-T (UNI-TREND) Group Limited\", Китай"
		);

		List<String> ids = Arrays.asList("235004276", "235000876", "235008623", "235002341",
				"235005921");

		List<String> serialNos = Arrays.asList("20240415", "20240528", "20240703", "20240819",
				"20241010");

		List<String> inventoryNos = Arrays.asList("NS20240415-1443", "NS20240528-1520",
				"NS20240703-1656", "NS20240819-1734", "NS20241010-1802");

		List<String> mtAcctRespValues = Arrays.asList("Лисовенко Д.А.", "Иванов А.П.",
				"Сидоров В.И.", "Петров М.С.");

		List<String> manufactureDates = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			manufactureDates.add(String.format("%d-%d-%d", random.nextInt(2025 - 2020) + 2020,
					random.nextInt(12) + 1, random.nextInt(28) + 1));
		}

		List<String> lastClosedWeValues = Arrays.asList("18.04.2024", null, "22.05.2024",
				"10.06.2024", "05.07.2024");

		for (int i = 0; i < 5; i++) {
			Composition composition = new Composition(
					mtTypes.get(random.nextInt(mtTypes.size())),
					ids.get(random.nextInt(ids.size())),
					serialNos.get(random.nextInt(serialNos.size())),
					inventoryNos.get(random.nextInt(inventoryNos.size())),
					mtAcctRespValues.get(random.nextInt(mtAcctRespValues.size())),
					manufactureDates.get(i),
					lastClosedWeValues.get(random.nextInt(lastClosedWeValues.size()))
			);
			compositions.add(composition);
		}

		return compositions;
	}

	private List<WoMtlg> generateRandomWoMtlg() {
		Random random = new Random();
		List<WoMtlg> woMtlgs = new ArrayList<>();

		List<String> execDivOrOrgValues = Arrays.asList(
				"ФБУ \"Государственный региональный центр стандартизации, метрологии и испытаний по Красноярскому краю, республике Хакасия и Тыва\"",
				"ООО \"Технический Центр\""
		);

		List<String> assigneePartyValues = Arrays.asList(
				"Лисовенко Д.А.",
				"Иванов А.П.",
				"Сидоров В.И.",
				"Петров М.С."
		);

		List<String> originValues = Arrays.asList(
				"По графику",
				"Экстренная работа",
				"Плановое обслуживание"
		);

		List<String> assetSuitblValues = Arrays.asList(
				"Годен",
				"Требует ремонта",
				"Находится в процессе проверки"
		);

		List<String> weStatusValues = Arrays.asList(
				"Закрыто",
				"Открыто",
				"На проверке"
		);

		String actualFinishTime1 = String.format("%d-%d-%d", random.nextInt(2025 - 2020) + 2020,
				random.nextInt(12) + 1, random.nextInt(28) + 1);
		String actualFinishTime2 = String.format("%d-%d-%d", random.nextInt(2025 - 2020) + 2020,
				random.nextInt(12) + 1, random.nextInt(28) + 1);

		WoMtlg woMtlg1 = new WoMtlg(
				execDivOrOrgValues.get(random.nextInt(execDivOrOrgValues.size())),
				assigneePartyValues.get(random.nextInt(assigneePartyValues.size())),
				originValues.get(random.nextInt(originValues.size())),
				assetSuitblValues.get(random.nextInt(assetSuitblValues.size())),
				weStatusValues.get(random.nextInt(weStatusValues.size())),
				actualFinishTime1
		);

		WoMtlg woMtlg2 = new WoMtlg(
				execDivOrOrgValues.get(random.nextInt(execDivOrOrgValues.size())),
				assigneePartyValues.get(random.nextInt(assigneePartyValues.size())),
				originValues.get(random.nextInt(originValues.size())),
				assetSuitblValues.get(random.nextInt(assetSuitblValues.size())),
				weStatusValues.get(random.nextInt(weStatusValues.size())),
				actualFinishTime2
		);

		woMtlgs.add(woMtlg1);
		woMtlgs.add(woMtlg2);

		return woMtlgs;
	}

	private List<Wo> generateRandomWo() {
		List<Wo> woList = new ArrayList<>();
		Random random = new Random();

		List<String> execDivOrOrgValues = Arrays.asList(
				"НПР\\Группа \"НН\"\\ООО \"ННР\"\\ПО \"Норильскремонт\"\\Аппарат объединения",
				"ОАО \"Газпром\", Филиал \"Сибирь\", Отдел \"Техническое обслуживание\"",
				"ФБУ \"Государственный региональный центр стандартизации, метрологии и испытаний по Красноярскому краю, республике Хакасия и Тыва\""
		);

		List<String> assigneePartyValues = Arrays.asList(
				"Гаязов И. В.",
				"Иванов П.С.",
				"Сидоров А.Н.",
				"Петров М.И."
		);

		List<String> originValues = Arrays.asList(
				"Внеочередная работа",
				"Плановая работа",
				"Ремонтный период",
				"Техническое обслуживание"
		);

		List<String> assetSuitblValues = Arrays.asList(
				"Годен",
				"Не годен",
				"Требует дополнительного обслуживания"
		);

		List<String> weStatusValues = Arrays.asList(
				"Закрыто",
				"Открыто",
				"В процессе",
				"Завершено"
		);

		String actualFinishTime = String.format("%d-%d-%d", random.nextInt(2025 - 2020) + 2020,
				random.nextInt(12) + 1, random.nextInt(28) + 1);

		Wo wo = new Wo(
				execDivOrOrgValues.get(random.nextInt(execDivOrOrgValues.size())),
				assigneePartyValues.get(random.nextInt(assigneePartyValues.size())),
				originValues.get(random.nextInt(originValues.size())),
				assetSuitblValues.get(random.nextInt(assetSuitblValues.size())),
				weStatusValues.get(random.nextInt(weStatusValues.size())),
				actualFinishTime
		);

		woList.add(wo);

		return woList;
	}
}
