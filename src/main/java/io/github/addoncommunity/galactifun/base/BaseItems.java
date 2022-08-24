package io.github.addoncommunity.galactifun.base;

import lombok.experimental.UtilityClass;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.addoncommunity.galactifun.Galactifun;
import io.github.addoncommunity.galactifun.api.items.Relic;
import io.github.addoncommunity.galactifun.api.items.spacesuit.SpaceSuit;
import io.github.addoncommunity.galactifun.api.items.spacesuit.SpaceSuitHelmet;
import io.github.addoncommunity.galactifun.api.items.spacesuit.SpaceSuitStat;
import io.github.addoncommunity.galactifun.api.items.spacesuit.SpaceSuitUpgrade;
import io.github.addoncommunity.galactifun.api.universe.attributes.atmosphere.Gas;
import io.github.addoncommunity.galactifun.api.worlds.AlienWorld;
import io.github.addoncommunity.galactifun.base.items.AssemblyTable;
import io.github.addoncommunity.galactifun.base.items.AtmosphericHarvester;
import io.github.addoncommunity.galactifun.base.items.AutomaticDoor;
import io.github.addoncommunity.galactifun.base.items.CircuitPress;
import io.github.addoncommunity.galactifun.base.items.DiamondAnvil;
import io.github.addoncommunity.galactifun.base.items.Electrolyzer;
import io.github.addoncommunity.galactifun.base.items.FusionReactor;
import io.github.addoncommunity.galactifun.base.items.LaunchPadCore;
import io.github.addoncommunity.galactifun.base.items.LaunchPadFloor;
import io.github.addoncommunity.galactifun.base.items.OxygenFiller;
import io.github.addoncommunity.galactifun.base.items.SpaceSuitUpgrader;
import io.github.addoncommunity.galactifun.base.items.StargateController;
import io.github.addoncommunity.galactifun.base.items.StargateRing;
import io.github.addoncommunity.galactifun.base.items.TechnologicalSalvager;
import io.github.addoncommunity.galactifun.base.items.knowledge.Observatory;
import io.github.addoncommunity.galactifun.base.items.knowledge.PlanetaryAnalyzer;
import io.github.addoncommunity.galactifun.base.items.protection.CoolingUnit;
import io.github.addoncommunity.galactifun.base.items.protection.ForcefieldGenerator;
import io.github.addoncommunity.galactifun.base.items.protection.IonDisperser;
import io.github.addoncommunity.galactifun.base.items.protection.OxygenSealer;
import io.github.addoncommunity.galactifun.base.items.protection.SpaceHeater;
import io.github.addoncommunity.galactifun.base.items.rockets.ChemicalRocket;
import io.github.addoncommunity.galactifun.base.items.rockets.IonRocket;
import io.github.addoncommunity.galactifun.core.CoreItemGroup;
import io.github.mooy1.infinitylib.machines.MachineBlock;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.utils.HeadTexture;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;

/**
 * Holds the base machines and setup
 */
@UtilityClass
public final class BaseItems {

    //<editor-fold desc="Space Suits, Oxygen, Upgrades" defaultstate="collapsed">
    public static final SlimefunItemStack OXYGEN_FILLER = new SlimefunItemStack(
            "OXYGEN_FILLER",
            new ItemStack(Material.QUARTZ_BLOCK),
            "&fКислородный заправщик",
            "",
            "&7Наполняет скафандры кислородом",
            "",
            LoreBuilder.machine(MachineTier.AVERAGE, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(100),
            LoreBuilder.speed(1)
    );
    public static final SlimefunItemStack SPACE_SUIT_UPGRADER = new SlimefunItemStack(
            "SPACE_SUIT_UPGRADER",
            new ItemStack(Material.IRON_BLOCK),
            "&fУлучшитель скафандра",
            "",
            "&7Добавляет улучшения к вашему скафандру",
            "",
            LoreBuilder.machine(MachineTier.AVERAGE, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(200),
            LoreBuilder.speed(1)
    );
    public static final SlimefunItemStack HEAT_RESISTANCE_UPGRADE = new SlimefunItemStack(
            "HEAT_RESISTANCE_UPGRADE",
            Material.IRON_BLOCK,
            "&7Повышение термостойкости",
            "",
            "&8Добавьте в свой скафандр для повышения термостойкости"
    );
    public static final SlimefunItemStack COLD_RESISTANCE_UPGRADE = new SlimefunItemStack(
            "COLD_RESISTANCE_UPGRADE",
            Material.IRON_BLOCK,
            "&7Повышение морозостойкости",
            "",
            "&8Дополните свой скафандр, чтобы повысить устойчивость к холоду"
    );
    public static final SlimefunItemStack RADIATION_RESISTANCE_UPGRADE = new SlimefunItemStack(
            "RADIATION_RESISTANCE_UPGRADE",
            Material.IRON_BLOCK,
            "&7Повышение радиационной стойкости",
            "",
            "&8Дополните свой скафандр, чтобы повысить устойчивость к радиации"
    );
    public static final SlimefunItemStack SPACE_SUIT_HELMET = new SlimefunItemStack(
            "SPACE_SUIT_HELMET",
            Material.GLASS,
            "&fШлем скафандра",
            "",
            "&7Базовый шлем скафандра",
            LoreBuilder.RIGHT_CLICK_TO_USE
    );
    public static final SlimefunItemStack SPACE_SUIT_CHEST = new SlimefunItemStack(
            "SPACE_SUIT_CHEST",
            Material.IRON_CHESTPLATE,
            "&fНагрудник скафандра",
            "",
            "&7Базовый нагрудник для скафандра",
            "",
            SpaceSuit.oxygenLore(0, 3600)
    );
    public static final SlimefunItemStack SPACE_SUIT_PANTS = new SlimefunItemStack(
            "SPACE_SUIT_PANTS",
            Material.IRON_LEGGINGS,
            "&fБрюки космического скафандра",
            "",
            "&7Базовая пара штанов космического скафандра"
    );
    public static final SlimefunItemStack SPACE_SUIT_BOOTS = new SlimefunItemStack(
            "SPACE_SUIT_BOOTS",
            Material.IRON_BOOTS,
            "&fБотинки в скафандре",
            "",
            "&7Базовая пара ботинок для скафандра"
    );
    //</editor-fold>
    //<editor-fold desc="Random Stuff" defaultstate="collapsed">
    public static final SlimefunItemStack LAUNCH_PAD_CORE = new SlimefunItemStack(
            "LAUNCH_PAD_CORE",
            Material.STONE,
            "&fЯдро пусковой площадки",
            "",
            "&7Окружите 8 блоками &fПола стартовой площадки&7",
            "&7для использования"
    );

    public static final SlimefunItemStack LAUNCH_PAD_FLOOR = new SlimefunItemStack(
            "LAUNCH_PAD_FLOOR",
            Material.STONE_SLAB,
            "&fПол стартовой площадки",
            "",
            "&7Используется при строительстве стартовой площадки"
    );

    public static final SlimefunItemStack CIRCUIT_PRESS = new SlimefunItemStack(
            "CIRCUIT_PRESS",
            Material.PISTON,
            "&fПресс для микросхем",
            "",
            "&7Создает микросхемы",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerBuffer(512),
            LoreBuilder.powerPerSecond(256)
    );
    public static final SlimefunItemStack ASSEMBLY_TABLE = new SlimefunItemStack(
            "ASSEMBLY_TABLE",
            Material.SMITHING_TABLE,
            "&fСборочный стол",
            "",
            "&7Используется для создания многих вещей",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.power(2048, "/Craft")
    );
    public static final SlimefunItemStack STARGATE_RING = new SlimefunItemStack(
            "STARGATE_RING",
            Material.QUARTZ_BLOCK,
            "&9Кольцо Звездных Врат",
            "",
            "&7Используется для строительства звездных врат"
    );
    public static final SlimefunItemStack STARGATE_CONTROLLER = new SlimefunItemStack(
            "STARGATE_CONTROLLER",
            Material.CHISELED_QUARTZ_BLOCK,
            "&9Контроллер Звездных Врат",
            "",
            "&7Используется для управления звездными вратами"
    );
    public static final SlimefunItemStack OBSERVATORY = new SlimefunItemStack(
            "OBSERVATORY",
            Material.GLASS,
            "&fОбсерватория",
            "",
            "&7Позволяет вам удаленно получать основную",
            "&7информацию о мире. Работает только в мирах,",
            "&7расположенных ближе, чем 0.25 ly (2,365,200,000,000 km)"
    );
    public static final SlimefunItemStack PLANETARY_ANALYZER = new SlimefunItemStack(
            "PLANETARY_ANALYZER",
            Material.SEA_LANTERN,
            "&fПланетарный анализатор",
            "",
            "&7Позволяет вам находить расширенную информацию",
            "&7о текущей планете"
    );
    public static final SlimefunItemStack DIAMOND_ANVIL = new SlimefunItemStack(
            "DIAMOND_ANVIL",
            Material.ANVIL,
            "&fАлмазная наковальня",
            "",
            "&7Сжимает материал так сильно, что",
            "&7он становится чем-то совершенно другим",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(1024),
            LoreBuilder.powerBuffer(2048)
    );
    public static final SlimefunItemStack FUSION_REACTOR = new SlimefunItemStack(
            "FUSION_REACTOR",
            HeadTexture.NUCLEAR_REACTOR.getAsItemStack(),
            "&fТермоядерный реактор",
            "",
            "&7Использует лазеры для перегрева гранул гелия-3",
            "&7и выработки большого количества",
            "&7энергии в процессе",
            "",
            LoreBuilder.powerPerSecond(65_536),
            LoreBuilder.powerBuffer(65_536)
    );
    public static final SlimefunItemStack ATMOSPHERIC_HARVESTER = new SlimefunItemStack(
            "ATMOSPHERIC_HARVESTER",
            GalactifunHead.ATMOSPHERIC_HARVESTER,
            "&fАтмосферный комбайн",
            "",
            "&7Собирает газы из атмосферы",
            LoreBuilder.powerPerSecond(64),
            LoreBuilder.powerBuffer(128),
            "",
            "&f&oТекстура от haseir"
    );
    public static final SlimefunItemStack CHEMICAL_REACTOR = new SlimefunItemStack(
            "CHEMICAL_REACTOR",
            Material.SEA_LANTERN,
            "&fХимический реактор",
            "",
            "&7Взаимодействует с химическими ",
            "&7веществами, создавая новые",
            LoreBuilder.powerPerSecond(256),
            LoreBuilder.powerBuffer(512)
    );
    public static final SlimefunItemStack ELECTROLYZER = new SlimefunItemStack(
            "ELECTROLYZER",
            Material.LANTERN,
            "&fЭлектролизер",
            "",
            "&7Использует электричество для расщепления",
            "&7химических веществ на их составляющие",
            LoreBuilder.powerPerSecond(256),
            LoreBuilder.powerBuffer(512)
    );
    //</editor-fold>
    //<editor-fold desc="Protecting Blocks" defaultstate="collapsed">
    public static final SlimefunItemStack COOLING_UNIT_1 = new SlimefunItemStack(
            "COOLING_UNIT_1",
            HeadTexture.COOLING_UNIT.getTexture(),
            "&bХолодильный агрегат I",
            "",
            "&7Эффект: понижение температуры",
            "&7Защита: 2",
            "&7Дальность действия: 1000 блоков",
            LoreBuilder.powerPerSecond(1024),
            LoreBuilder.powerBuffer(2048)
    );
    public static final SlimefunItemStack COOLING_UNIT_2 = new SlimefunItemStack(
            "COOLING_UNIT_2",
            HeadTexture.COOLING_UNIT.getTexture(),
            "&bолодильный агрегат II",
            "",
            "&7Эффект: понижение температуры",
            "&7Защита: 4",
            "&7Дальность действия: 1500 блоков",
            LoreBuilder.powerPerSecond(2048),
            LoreBuilder.powerBuffer(4096)
    );
    public static final SlimefunItemStack COOLING_UNIT_3 = new SlimefunItemStack(
            "COOLING_UNIT_3",
            HeadTexture.COOLING_UNIT.getTexture(),
            "&bолодильный агрегат III",
            "",
            "&7Эффект: понижение температуры",
            "&7Защита: 6",
            "&7Дальность действия: 2000 блоков",
            LoreBuilder.powerPerSecond(3072),
            LoreBuilder.powerBuffer(6144)
    );
    public static final SlimefunItemStack SPACE_HEATER_1 = new SlimefunItemStack(
            "SPACE_HEATER_1",
            Material.SHROOMLIGHT,
            "&6пространственный обогреватель I",
            "",
            "&7Эффект: повышение температуры",
            "&7Защита: 2",
            "&7Дальность действия: 1000 блоков",
            LoreBuilder.powerPerSecond(512),
            LoreBuilder.powerBuffer(1024)
    );
    public static final SlimefunItemStack SPACE_HEATER_2 = new SlimefunItemStack(
            "SPACE_HEATER_2",
            Material.SHROOMLIGHT,
            "&6пространственный обогреватель II",
            "",
            "&7Эффект: повышение температуры",
            "&7Защита: 4",
            "&7Дальность действия: 1500 блоков",
            LoreBuilder.powerPerSecond(1024),
            LoreBuilder.powerBuffer(2048)
    );
    public static final SlimefunItemStack SPACE_HEATER_3 = new SlimefunItemStack(
            "SPACE_HEATER_3",
            Material.SHROOMLIGHT,
            "&6пространственный обогреватель III",
            "",
            "&7Эффект: повышение температуры",
            "&7Защита: 6",
            "&7Дальность действия: 2000 блоков",
            LoreBuilder.powerPerSecond(2048),
            LoreBuilder.powerBuffer(4096)
    );
    public static final SlimefunItemStack ION_DISPERSER_1 = new SlimefunItemStack(
            "ION_DISPERSER_1",
            Material.PRISMARINE,
            "&fРассеиватель ионов I",
            "",
            "&7Эффект: Радиация",
            "&7Защита: 2",
            "&Дальность действия: 1000 блоков",
            LoreBuilder.powerPerSecond(512),
            LoreBuilder.powerBuffer(1024)
    );
    public static final SlimefunItemStack ION_DISPERSER_2 = new SlimefunItemStack(
            "ION_DISPERSER_2",
            Material.PRISMARINE,
            "&fРассеиватель ионов II",
            "",
            "&7Эффект: Радиация",
            "&7Защита: 4",
            "&7Дальность действия: 1500 блоков",
            LoreBuilder.powerPerSecond(1024),
            LoreBuilder.powerBuffer(2048)
    );
    public static final SlimefunItemStack OXYGEN_SEALER = new SlimefunItemStack(
            "OXYGEN_SEALER",
            Material.FURNACE,
            "&fКислородный заполнитель",
            "",
            "&7Заполняет герметичную область кислородом. Дальность действия 1000 блоков"
    );
    public static final SlimefunItemStack LANDING_HATCH = new SlimefunItemStack(
            "LANDING_HATCH",
            Material.IRON_TRAPDOOR,
            "&fПосадочный люк",
            "",
            "&7Ракеты игнорируют этот блок при посадке;",
            "&7они приземлятся на самый высокий",
            "&7блок под ним.Он считается непроходимым",
            "&7для воздуха, поэтому его можно использовать",
            "&7для герметизации помещений"
    );
    public static final SlimefunItemStack SUPER_FAN = new SlimefunItemStack(
            "SUPER_FAN",
            Material.WHITE_WOOL,
            "&7Супер вентилятор",
            "",
            "&7Поместите это рядом с блоком, которому требуется",
            "&7закрытая область, чтобы увеличить диапазон на 15%"
    );
    public static final SlimefunItemStack AUTOMATIC_DOOR = new SlimefunItemStack(
            "AUTOMATIC_DOOR",
            Material.OBSERVER,
            "&fАвтоматическая дверь",
            "",
            "&7Автоматически помещает / удаляет блоки",
            "&7внутри, когда вы идете к нему / от него"
    );
    public static final SlimefunItemStack ENVIRONMENTAL_FORCEFIELD_GENERATOR = new SlimefunItemStack(
            "ENVIRONMENTAL_FORCEFIELD_GENERATOR",
            Material.DISPENSER,
            "&fГенератор силового поля окружающей среды",
            "",
            "&7Создает силовое поле, которое не пропускает воздух, ",
            "&7но позволяет проходить сущностям"
    );
    //</editor-fold>
    //<editor-fold desc="Relics" defaultstate="collapsed">
    public static final SlimefunItemStack ENGINE_RELIC = new SlimefunItemStack(
            "ENGINE_RELIC",
            Material.SEA_LANTERN,
            "&fРеликвия: 'Ьлетагивд Йынмуукав",
            "",
            "&7Дерепв ьлбарок ьтагивд ыботч амукав",
            "&7юигрене теузьлопси ьлетагивд тотэ"
    );
    public static final SlimefunItemStack REACTOR_RELIC = new SlimefunItemStack(
            "REACTOR_RELIC",
            Material.BEACON,
            "&fРеликвия: Ротаренегорткелэ Йынмукав",
            "",
            "&7Огечин зи ьтарибос онжом юигрене",
            "&7отч ламуд отк?"
    );
    public static final SlimefunItemStack COMPUTER_RELIC = new SlimefunItemStack(
            "COMPUTER_RELIC",
            GalactifunHead.CORE,
            "&fРеликвия: Ретюьпмок Йывотнавк",
            "",
            "&7Ыретюьпмок еынчыбо меч еертсыб огонман",
            "&7яинелсичыв ьталед тугом ыретюьпмок еывотнавк"
    );
    public static final SlimefunItemStack BROKEN_SOLAR_PANEL_RELIC = new SlimefunItemStack(
            "BROKEN_SOLAR_PANEL_RELIC",
            Material.DAYLIGHT_DETECTOR,
            "&7Реликвия: Ьленап Аянченлос Аянамолоп",
            "",
            "&7Ьленап аянченлос яаратс ьнечо"
    );
    public static final SlimefunItemStack FALLEN_SATELLITE_RELIC = new SlimefunItemStack(
            "FALLEN_SATELLITE_RELIC",
            Material.CHISELED_QUARTZ_BLOCK,
            "&7Реликвия: Кинтупс Йишвапу",
            "",
            "&7Абен с лапу йыроток, кинтупс"
    );
    public static final SlimefunItemStack TECHNOLOGICAL_SALVAGER = new SlimefunItemStack(
            "TECHNOLOGICAL_SALVAGER",
            GalactifunHead.CORE,
            "&fТехнологический утилизатор",
            "",
            "&7Собирает все, что можно спасти из реликвий",
            LoreBuilder.powerPerSecond(64),
            LoreBuilder.powerBuffer(64)
    );
    //</editor-fold>
    //<editor-fold desc="Rock It" defaultstate="collapsed">
    private static final int TIER_ONE_FUEL = 10;
    private static final int TIER_ONE_STORAGE = 9;
    public static final SlimefunItemStack TIER_ONE = new SlimefunItemStack(
            "ROCKET_TIER_ONE",
            GalactifunHead.ROCKET,
            "&4Химическая ракета Уровня 1",
            "",
            "&7Запас топлива: " + TIER_ONE_FUEL,
            "&7Грузоподъемность: " + TIER_ONE_STORAGE
    );
    private static final int TIER_TWO_FUEL = 100;
    private static final int TIER_TWO_STORAGE = 18;
    public static final SlimefunItemStack TIER_TWO = new SlimefunItemStack(
            "ROCKET_TIER_TWO",
            GalactifunHead.ROCKET,
            "&4Химическая ракета Уровня 2",
            "",
            "&7Запас топлива: " + TIER_TWO_FUEL,
            "&7Грузоподъемность: " + TIER_TWO_STORAGE
    );
    private static final int TIER_THREE_FUEL = 500;
    private static final int TIER_THREE_STORAGE = 36;
    public static final SlimefunItemStack TIER_THREE = new SlimefunItemStack(
            "ROCKET_TIER_THREE",
            GalactifunHead.ROCKET,
            "&4Химическая ракета Уровня 3",
            "",
            "&7Запас топлива: " + TIER_THREE_FUEL,
            "&7Грузоподъемность: " + TIER_THREE_STORAGE
    );
    public static final SlimefunItemStack ION_ROCKET = new SlimefunItemStack(
            "ION_ROCKET",
            GalactifunHead.ION_ROCKET,
            "&bИонная Ракета",
            "",
            "&7использует специализированный двигатель, который",
            "&7выталкивает ионы с большой скоростью, обеспечивая",
            "&7экстремальную топливную экономичность",
            "",
            "&7Запас топлива: 500",
            "&7Грузоподъемность: 18"
    );
    //</editor-fold>

    public static void setup(Galactifun galactifun) {
        new OxygenFiller(CoreItemGroup.MACHINES, OXYGEN_FILLER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                BaseMats.ALUMINUM_COMPOSITE, BaseMats.REINFORCED_CHANNEL, BaseMats.ALUMINUM_COMPOSITE,
                BaseMats.ALUMINUM_COMPOSITE, BaseMats.FAN_BLADE, BaseMats.ALUMINUM_COMPOSITE,
                BaseMats.ALUMINUM_COMPOSITE, null, BaseMats.ALUMINUM_COMPOSITE
        }).setCapacity(200).setEnergyConsumption(100).setProcessingSpeed(1).register(galactifun);
        new SpaceSuitUpgrader(CoreItemGroup.MACHINES, SPACE_SUIT_UPGRADER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                BaseMats.ALUMINUM_COMPOSITE, SlimefunItems.HARDENED_GLASS, BaseMats.ALUMINUM_COMPOSITE,
                BaseMats.ALUMINUM_COMPOSITE, null, BaseMats.ALUMINUM_COMPOSITE,
                BaseMats.ALUMINUM_COMPOSITE, SlimefunItems.STEEL_INGOT, BaseMats.ALUMINUM_COMPOSITE
        }).setCapacity(400).setEnergyConsumption(200).setProcessingSpeed(1).register(galactifun);

        new SpaceSuitUpgrade(CoreItemGroup.EQUIPMENT, HEAT_RESISTANCE_UPGRADE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.COOLING_UNIT, SlimefunItems.COOLING_UNIT, SlimefunItems.COOLING_UNIT,
                SlimefunItems.COOLING_UNIT, new ItemStack(Material.IRON_BLOCK), SlimefunItems.COOLING_UNIT,
                SlimefunItems.COOLING_UNIT, SlimefunItems.COOLING_UNIT, SlimefunItems.COOLING_UNIT
        }, SpaceSuitStat.HEAT_RESISTANCE, 1).register(galactifun);
        new SpaceSuitUpgrade(CoreItemGroup.EQUIPMENT, COLD_RESISTANCE_UPGRADE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.HEATING_COIL, SlimefunItems.HEATING_COIL, SlimefunItems.HEATING_COIL,
                SlimefunItems.HEATING_COIL, new ItemStack(Material.IRON_BLOCK), SlimefunItems.HEATING_COIL,
                SlimefunItems.HEATING_COIL, SlimefunItems.HEATING_COIL, SlimefunItems.HEATING_COIL
        }, SpaceSuitStat.COLD_RESISTANCE, 1).register(galactifun);
        new SpaceSuitUpgrade(CoreItemGroup.EQUIPMENT, RADIATION_RESISTANCE_UPGRADE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.LEAD_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.LEAD_INGOT,
                SlimefunItems.LEAD_INGOT, new ItemStack(Material.IRON_BLOCK), SlimefunItems.LEAD_INGOT,
                SlimefunItems.LEAD_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.LEAD_INGOT
        }, SpaceSuitStat.RADIATION_RESISTANCE, 1).register(galactifun);

        new SpaceSuitHelmet(CoreItemGroup.EQUIPMENT, SPACE_SUIT_HELMET, RecipeType.ARMOR_FORGE, new ItemStack[] {
                BaseMats.ALUMINUM_COMPOSITE_SHEET, BaseMats.GOLD_FOIL, BaseMats.ALUMINUM_COMPOSITE_SHEET,
                SlimefunItems.REINFORCED_CLOTH, SlimefunItems.SCUBA_HELMET, SlimefunItems.REINFORCED_CLOTH,
                BaseMats.REINFORCED_CHANNEL, BaseMats.OXYGEN_REGENERATOR, BaseMats.FAN_BLADE
        }, 3, 0).register(galactifun);
        new SpaceSuit(CoreItemGroup.EQUIPMENT, SPACE_SUIT_CHEST, RecipeType.ARMOR_FORGE, new ItemStack[] {
                BaseMats.ALUMINUM_COMPOSITE_SHEET, SlimefunItems.REINFORCED_CLOTH, BaseMats.REINFORCED_CHANNEL,
                BaseMats.FAN_BLADE, SlimefunItems.HAZMAT_CHESTPLATE, BaseMats.FAN_BLADE,
                BaseMats.ALUMINUM_COMPOSITE_SHEET, BaseMats.ALUMINUM_COMPOSITE_SHEET, BaseMats.ALUMINUM_COMPOSITE_SHEET
        }, 3, 3600).register(galactifun);
        new SpaceSuit(CoreItemGroup.EQUIPMENT, SPACE_SUIT_PANTS, RecipeType.ARMOR_FORGE, new ItemStack[] {
                BaseMats.ALUMINUM_COMPOSITE_SHEET, SlimefunItems.HAZMAT_LEGGINGS, BaseMats.ALUMINUM_COMPOSITE_SHEET,
                BaseMats.ALUMINUM_COMPOSITE_SHEET, null, BaseMats.ALUMINUM_COMPOSITE_SHEET,
                BaseMats.ALUMINUM_COMPOSITE_SHEET, null, BaseMats.ALUMINUM_COMPOSITE_SHEET
        }, 2, 0).register(galactifun);
        new SpaceSuit(CoreItemGroup.EQUIPMENT, SPACE_SUIT_BOOTS, RecipeType.ARMOR_FORGE, new ItemStack[] {
                null, null, null,
                BaseMats.ALUMINUM_COMPOSITE_SHEET, null, BaseMats.ALUMINUM_COMPOSITE_SHEET,
                BaseMats.ALUMINUM_COMPOSITE_SHEET, SlimefunItems.HAZMAT_BOOTS, BaseMats.ALUMINUM_COMPOSITE_SHEET
        }, 2, 0).register(galactifun);

        new CircuitPress(CoreItemGroup.MACHINES, CIRCUIT_PRESS, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.HEATING_COIL, new ItemStack(Material.PISTON), SlimefunItems.HEATING_COIL,
                BaseMats.ALUMINUM_COMPOSITE_SHEET, null, BaseMats.ALUMINUM_COMPOSITE_SHEET,
                SlimefunItems.HEATING_COIL, new ItemStack(Material.PISTON), SlimefunItems.HEATING_COIL
        }).setCapacity(512).setEnergyConsumption(128).setProcessingSpeed(1).register(galactifun);

        new AssemblyTable(ASSEMBLY_TABLE, new ItemStack[] {
                SlimefunItems.STEEL_PLATE, SlimefunItems.ENHANCED_AUTO_CRAFTER, SlimefunItems.STEEL_PLATE,
                SlimefunItems.CARGO_MOTOR, BaseMats.ADVANCED_PROCESSING_UNIT, SlimefunItems.CARGO_MOTOR,
                SlimefunItems.REINFORCED_PLATE, SlimefunItems.REINFORCED_PLATE, SlimefunItems.REINFORCED_PLATE
        }, 2048).register(galactifun);

        new StargateRing(CoreItemGroup.COMPONENTS, STARGATE_RING, AssemblyTable.TYPE, new ItemStack[] {
                BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET,
                BaseMats.ULTRA_DUTY_SHEET, BaseMats.ENDER_BLOCK, BaseMats.ENDER_BLOCK, BaseMats.ENDER_BLOCK, BaseMats.ENDER_BLOCK, BaseMats.ULTRA_DUTY_SHEET,
                BaseMats.ULTRA_DUTY_SHEET, BaseMats.ENDER_BLOCK, BaseMats.ENDER_BLOCK, BaseMats.ENDER_BLOCK, BaseMats.ENDER_BLOCK, BaseMats.ULTRA_DUTY_SHEET,
                BaseMats.ULTRA_DUTY_SHEET, BaseMats.ENDER_BLOCK, BaseMats.ENDER_BLOCK, BaseMats.ENDER_BLOCK, BaseMats.ENDER_BLOCK, BaseMats.ULTRA_DUTY_SHEET,
                BaseMats.ULTRA_DUTY_SHEET, BaseMats.ENDER_BLOCK, BaseMats.ENDER_BLOCK, BaseMats.ENDER_BLOCK, BaseMats.ENDER_BLOCK, BaseMats.ULTRA_DUTY_SHEET,
                BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET
        }).register(galactifun);
        new StargateController(CoreItemGroup.COMPONENTS, STARGATE_CONTROLLER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                STARGATE_RING, BaseMats.GLOWSTONE_CIRCUIT, STARGATE_RING,
                BaseMats.REDSTONE_CIRCUIT, BaseMats.DIAMOND_CIRCUIT, BaseMats.REDSTONE_CIRCUIT,
                STARGATE_RING, BaseMats.LAPIS_CIRCUIT, STARGATE_RING
        }).register(galactifun);

        new ChemicalRocket(CoreItemGroup.ITEMS, TIER_ONE, AssemblyTable.TYPE, new ItemStack[] {
                null, null, BaseMats.NOSE_CONE, BaseMats.NOSE_CONE, null, null,
                null, null, BaseMats.HEAVY_DUTY_SHEET, BaseMats.HEAVY_DUTY_SHEET, null, null,
                null, BaseMats.HEAVY_DUTY_SHEET, BaseMats.ADVANCED_PROCESSING_UNIT, BaseMats.ADVANCED_PROCESSING_UNIT, BaseMats.HEAVY_DUTY_SHEET, null,
                BaseMats.HEAVY_DUTY_SHEET, BaseMats.FUEL_TANK, BaseMats.LIFE_SUPPORT_MODULE, BaseMats.LIFE_SUPPORT_MODULE, BaseMats.FUEL_TANK, BaseMats.HEAVY_DUTY_SHEET,
                BaseMats.HEAVY_DUTY_SHEET, BaseMats.FUEL_TANK, BaseMats.FUEL_TANK, BaseMats.FUEL_TANK, BaseMats.FUEL_TANK, BaseMats.HEAVY_DUTY_SHEET,
                BaseMats.HEAVY_DUTY_SHEET, null, BaseMats.ROCKET_ENGINE, BaseMats.ROCKET_ENGINE, null, BaseMats.HEAVY_DUTY_SHEET
        }, TIER_ONE_FUEL, TIER_ONE_STORAGE).register(galactifun);
        new ChemicalRocket(CoreItemGroup.ITEMS, TIER_TWO, AssemblyTable.TYPE, new ItemStack[] {
                null, null, BaseMats.NOSE_CONE, BaseMats.NOSE_CONE, null, null,
                null, null, BaseMats.HEAVY_DUTY_SHEET, BaseMats.HEAVY_DUTY_SHEET, null, null,
                null, BaseMats.HEAVY_DUTY_SHEET, BaseMats.ADVANCED_PROCESSING_UNIT, BaseMats.ADVANCED_PROCESSING_UNIT, BaseMats.HEAVY_DUTY_SHEET, null,
                BaseMats.HEAVY_DUTY_SHEET, BaseMats.FUEL_TANK, BaseMats.LIFE_SUPPORT_MODULE, BaseMats.LIFE_SUPPORT_MODULE, BaseMats.FUEL_TANK, BaseMats.HEAVY_DUTY_SHEET,
                BaseMats.HEAVY_DUTY_SHEET, BaseMats.FUEL_TANK, BaseMats.FUEL_TANK, BaseMats.FUEL_TANK, BaseMats.FUEL_TANK, BaseMats.HEAVY_DUTY_SHEET,
                BaseMats.HEAVY_DUTY_SHEET, null, BaseMats.ROCKET_ENGINE_2, BaseMats.ROCKET_ENGINE_2, null, BaseMats.HEAVY_DUTY_SHEET
        }, TIER_TWO_FUEL, TIER_TWO_STORAGE).register(galactifun);
        new ChemicalRocket(CoreItemGroup.ITEMS, TIER_THREE, AssemblyTable.TYPE, new ItemStack[] {
                null, null, BaseMats.NOSE_CONE, BaseMats.NOSE_CONE, null, null,
                null, null, BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET, null, null,
                null, BaseMats.HEAVY_DUTY_SHEET, BaseMats.ADVANCED_PROCESSING_UNIT, BaseMats.ADVANCED_PROCESSING_UNIT, BaseMats.ULTRA_DUTY_SHEET, null,
                BaseMats.ULTRA_DUTY_SHEET, BaseMats.FUEL_TANK_2, BaseMats.LIFE_SUPPORT_MODULE, BaseMats.LIFE_SUPPORT_MODULE, BaseMats.FUEL_TANK_2, BaseMats.ULTRA_DUTY_SHEET,
                BaseMats.ULTRA_DUTY_SHEET, BaseMats.FUEL_TANK_2, BaseMats.FUEL_TANK, BaseMats.FUEL_TANK, BaseMats.FUEL_TANK_2, BaseMats.ULTRA_DUTY_SHEET,
                BaseMats.ULTRA_DUTY_SHEET, null, BaseMats.ROCKET_ENGINE_3, BaseMats.ROCKET_ENGINE_3, null, BaseMats.ULTRA_DUTY_SHEET
        }, TIER_THREE_FUEL, TIER_THREE_STORAGE).register(galactifun);

        new SlimefunItem(CoreItemGroup.ITEMS, LANDING_HATCH, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                BaseMats.HEAVY_DUTY_SHEET, new ItemStack(Material.IRON_TRAPDOOR), BaseMats.HEAVY_DUTY_SHEET,
                BaseMats.SPACE_GRADE_PLATE, null, BaseMats.SPACE_GRADE_PLATE,
                BaseMats.SPACE_GRADE_PLATE, null, BaseMats.SPACE_GRADE_PLATE
        }).register(galactifun);

        new LaunchPadFloor(CoreItemGroup.ITEMS, BaseItems.LAUNCH_PAD_FLOOR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                null, null, null,
                BaseMats.HEAVY_DUTY_SHEET, BaseMats.HEAVY_DUTY_SHEET, BaseMats.HEAVY_DUTY_SHEET,
                BaseMats.HEAVY_DUTY_SHEET, BaseMats.HEAVY_DUTY_SHEET, BaseMats.HEAVY_DUTY_SHEET,
        }).register(galactifun);

        new LaunchPadCore(CoreItemGroup.ITEMS, BaseItems.LAUNCH_PAD_CORE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.REINFORCED_PLATE, BaseMats.NOZZLE, SlimefunItems.REINFORCED_PLATE,
                SlimefunItems.CARGO_MOTOR, SlimefunItems.OIL_PUMP, SlimefunItems.CARGO_MOTOR,
                SlimefunItems.REINFORCED_PLATE, BaseMats.ADVANCED_PROCESSING_UNIT, SlimefunItems.REINFORCED_PLATE,
        }).register(galactifun);

        new CoolingUnit(COOLING_UNIT_1, new ItemStack[] {
                BaseMats.ALUMINUM_COMPOSITE_SHEET, SlimefunItems.COOLING_UNIT, BaseMats.ALUMINUM_COMPOSITE_SHEET,
                SlimefunItems.COOLING_UNIT, BaseMats.FAN_BLADE, SlimefunItems.COOLING_UNIT,
                BaseMats.ALUMINUM_COMPOSITE_SHEET, SlimefunItems.COOLING_UNIT, BaseMats.ALUMINUM_COMPOSITE_SHEET
        }, 1).register(galactifun);

        new CoolingUnit(COOLING_UNIT_2, new ItemStack[] {
                BaseMats.SPACE_GRADE_PLATE, BaseMats.DRY_ICE, BaseMats.SPACE_GRADE_PLATE,
                BaseMats.DRY_ICE, COOLING_UNIT_1, BaseMats.DRY_ICE,
                BaseMats.SPACE_GRADE_PLATE, BaseMats.DRY_ICE, BaseMats.SPACE_GRADE_PLATE
        }, 2).register(galactifun);

        new CoolingUnit(COOLING_UNIT_3, new ItemStack[] {
                BaseMats.HEAVY_DUTY_SHEET, BaseMats.DRY_ICE, BaseMats.HEAVY_DUTY_SHEET,
                BaseMats.DRY_ICE, COOLING_UNIT_2, BaseMats.DRY_ICE,
                BaseMats.HEAVY_DUTY_SHEET, BaseMats.DRY_ICE, BaseMats.HEAVY_DUTY_SHEET
        }, 3).register(galactifun);

        new SpaceHeater(SPACE_HEATER_1, new ItemStack[] {
                BaseMats.ALUMINUM_COMPOSITE_SHEET, SlimefunItems.HEATING_COIL, BaseMats.ALUMINUM_COMPOSITE_SHEET,
                SlimefunItems.HEATING_COIL, BaseMats.FAN_BLADE, SlimefunItems.HEATING_COIL,
                BaseMats.ALUMINUM_COMPOSITE_SHEET, SlimefunItems.HEATING_COIL, BaseMats.ALUMINUM_COMPOSITE_SHEET
        }, 1).register(galactifun);

        new SpaceHeater(SPACE_HEATER_2, new ItemStack[] {
                BaseMats.SPACE_GRADE_PLATE, new ItemStack(Material.LAVA_BUCKET), BaseMats.SPACE_GRADE_PLATE,
                BaseMats.VENTSTONE, SPACE_HEATER_1, BaseMats.VENTSTONE,
                BaseMats.SPACE_GRADE_PLATE, SlimefunItems.HEATING_COIL, BaseMats.SPACE_GRADE_PLATE
        }, 2).register(galactifun);

        new SpaceHeater(SPACE_HEATER_3, new ItemStack[] {
                BaseMats.HEAVY_DUTY_SHEET, BaseMats.VOLCANIC_INGOT, BaseMats.HEAVY_DUTY_SHEET,
                BaseMats.VOLCANIC_INGOT, SPACE_HEATER_2, BaseMats.VOLCANIC_INGOT,
                BaseMats.HEAVY_DUTY_SHEET, BaseMats.BLISTERING_VOLCANIC_INGOT, BaseMats.HEAVY_DUTY_SHEET
        }, 3).register(galactifun);

        new IonDisperser(ION_DISPERSER_1, new ItemStack[] {
                BaseMats.ALUMINUM_COMPOSITE_SHEET, BaseMats.FAN_BLADE, BaseMats.ALUMINUM_COMPOSITE_SHEET,
                new ItemStack(Material.PRISMARINE_CRYSTALS), BaseMats.SULFUR_BLOCK, new ItemStack(Material.PRISMARINE_CRYSTALS),
                BaseMats.ALUMINUM_COMPOSITE_SHEET, BaseMats.VENTSTONE, BaseMats.ALUMINUM_COMPOSITE_SHEET
        }, 1).register(galactifun);

        new IonDisperser(ION_DISPERSER_2, new ItemStack[] {
                BaseMats.SPACE_GRADE_PLATE, BaseMats.FAN_BLADE, BaseMats.SPACE_GRADE_PLATE,
                BaseMats.SULFUR_BLOCK, ION_DISPERSER_1, BaseMats.SULFUR_BLOCK,
                BaseMats.SPACE_GRADE_PLATE, BaseMats.BLISTERING_VOLCANIC_INGOT, BaseMats.SPACE_GRADE_PLATE
        }, 2).register(galactifun);

        new Observatory(OBSERVATORY, new ItemStack[] {
                new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.PISTON), new ItemStack(Material.IRON_BLOCK),
                new ItemStack(Material.PISTON), BaseMats.LUNAR_GLASS, new ItemStack(Material.PISTON),
                new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.PISTON), new ItemStack(Material.IRON_BLOCK)
        }).register(galactifun);
        new PlanetaryAnalyzer(PLANETARY_ANALYZER, new ItemStack[] {
                BaseMats.TUNGSTEN_INGOT, SlimefunItems.GPS_TRANSMITTER_4, BaseMats.TUNGSTEN_INGOT,
                BaseMats.SPACE_GRADE_PLATE, SlimefunItems.ENERGIZED_CAPACITOR, BaseMats.SPACE_GRADE_PLATE,
                BaseMats.TUNGSTEN_INGOT, BaseMats.VOLCANIC_INGOT, BaseMats.TUNGSTEN_INGOT
        }).register(galactifun);
        new DiamondAnvil(DIAMOND_ANVIL, new ItemStack[] {
                BaseMats.ULTRA_DUTY_SHEET, new ItemStack(Material.GLASS), BaseMats.ULTRA_DUTY_SHEET,
                BaseMats.ULTRA_DUTY_SHEET, BaseMats.DIAMOND_ANVIL_CELL, BaseMats.ULTRA_DUTY_SHEET,
                BaseMats.ULTRA_DUTY_SHEET, new ItemStack(Material.ANVIL), BaseMats.ULTRA_DUTY_SHEET
        }).setCapacity(2048).setEnergyConsumption(512).setProcessingSpeed(1).register(galactifun);

        new OxygenSealer(OXYGEN_SEALER, new ItemStack[] {
                BaseMats.ALUMINUM_COMPOSITE_SHEET, BaseMats.FAN_BLADE, BaseMats.ALUMINUM_COMPOSITE_SHEET,
                BaseMats.ALUMINUM_COMPOSITE_SHEET, BaseMats.REINFORCED_CHANNEL, BaseMats.ALUMINUM_COMPOSITE_SHEET,
                BaseMats.ALUMINUM_COMPOSITE_SHEET, BaseMats.OXYGEN_REGENERATOR, BaseMats.ALUMINUM_COMPOSITE_SHEET
        }, 1000).register(galactifun);

        new SlimefunItem(CoreItemGroup.ITEMS, SUPER_FAN, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                BaseMats.ALUMINUM_COMPOSITE_SHEET, BaseMats.ALUMINUM_COMPOSITE_SHEET, BaseMats.ALUMINUM_COMPOSITE_SHEET,
                BaseMats.ALUMINUM_COMPOSITE_SHEET, BaseMats.FAN_BLADE, BaseMats.ALUMINUM_COMPOSITE_SHEET,
                BaseMats.ALUMINUM_COMPOSITE_SHEET, BaseMats.VENTSTONE, BaseMats.ALUMINUM_COMPOSITE_SHEET
        }).register(galactifun);

        new AutomaticDoor(AUTOMATIC_DOOR, new ItemStack[] {
                BaseMats.ALUMINUM_COMPOSITE_SHEET, new ItemStack(Material.OBSERVER), BaseMats.ALUMINUM_COMPOSITE_SHEET,
                BaseMats.ALUMINUM_COMPOSITE_SHEET, SlimefunItems.PROGRAMMABLE_ANDROID_MINER, BaseMats.ALUMINUM_COMPOSITE_SHEET,
                BaseMats.ALUMINUM_COMPOSITE_SHEET, SlimefunItems.BLOCK_PLACER, BaseMats.ALUMINUM_COMPOSITE_SHEET
        }).register(galactifun);

        new ForcefieldGenerator(ENVIRONMENTAL_FORCEFIELD_GENERATOR, new ItemStack[] {
                BaseMats.ALUMINUM_COMPOSITE_SHEET, BaseMats.ENDER_BLOCK, BaseMats.ALUMINUM_COMPOSITE_SHEET,
                BaseMats.ALUMINUM_COMPOSITE_SHEET, ION_DISPERSER_1, BaseMats.ALUMINUM_COMPOSITE_SHEET,
                BaseMats.ALUMINUM_COMPOSITE_SHEET, BaseMats.SPACE_GRADE_PLATE, BaseMats.ALUMINUM_COMPOSITE_SHEET
        }).register(galactifun);

        new FusionReactor(FUSION_REACTOR, new ItemStack[] {
                BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET, BaseMats.ADVANCED_PROCESSING_UNIT, BaseMats.ADVANCED_PROCESSING_UNIT, BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET,
                BaseMats.ULTRA_DUTY_SHEET, BaseMats.BLISTERING_VOLCANIC_INGOT, BaseMats.LASERITE, BaseMats.LASERITE, BaseMats.BLISTERING_VOLCANIC_INGOT, BaseMats.ULTRA_DUTY_SHEET,
                BaseMats.ULTRA_DUTY_SHEET, BaseMats.LASERITE, BaseMats.FUSION_PELLET, BaseMats.FUSION_PELLET, BaseMats.LASERITE, BaseMats.ULTRA_DUTY_SHEET,
                BaseMats.ULTRA_DUTY_SHEET, BaseMats.LASERITE, BaseMats.FUSION_PELLET, BaseMats.FUSION_PELLET, BaseMats.LASERITE, BaseMats.ULTRA_DUTY_SHEET,
                BaseMats.ULTRA_DUTY_SHEET, BaseMats.BLISTERING_VOLCANIC_INGOT, BaseMats.LASERITE, BaseMats.LASERITE, BaseMats.BLISTERING_VOLCANIC_INGOT, BaseMats.ULTRA_DUTY_SHEET,
                BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET,
        }).register(galactifun);

        new AtmosphericHarvester(ATMOSPHERIC_HARVESTER, new ItemStack[] {
                BaseMats.SPACE_GRADE_PLATE, BaseMats.FAN_BLADE, BaseMats.SPACE_GRADE_PLATE,
                BaseMats.SPACE_GRADE_PLATE, null, BaseMats.SPACE_GRADE_PLATE,
                BaseMats.SPACE_GRADE_PLATE, BaseMats.SPACE_GRADE_PLATE, BaseMats.SPACE_GRADE_PLATE
        }).register(galactifun);

        new IonRocket(ION_ROCKET, new ItemStack[] {
                null, null, BaseMats.NOSE_CONE, BaseMats.NOSE_CONE, null, null,
                null, null, BaseMats.ULTRA_DUTY_SHEET, BaseMats.ULTRA_DUTY_SHEET, null, null,
                null, BaseMats.HEAVY_DUTY_SHEET, BaseMats.ADVANCED_PROCESSING_UNIT, BaseMats.ADVANCED_PROCESSING_UNIT, BaseMats.ULTRA_DUTY_SHEET, null,
                BaseMats.ULTRA_DUTY_SHEET, FUSION_REACTOR, BaseMats.LIFE_SUPPORT_MODULE, BaseMats.LIFE_SUPPORT_MODULE, SlimefunItems.ENERGIZED_CAPACITOR, BaseMats.ULTRA_DUTY_SHEET,
                BaseMats.ULTRA_DUTY_SHEET, BaseMats.FUEL_TANK_2, BaseMats.FUEL_TANK, BaseMats.FUEL_TANK, BaseMats.FUEL_TANK_2, BaseMats.ULTRA_DUTY_SHEET,
                BaseMats.ULTRA_DUTY_SHEET, null, BaseMats.ION_ENGINE, BaseMats.ION_ENGINE, null, BaseMats.ULTRA_DUTY_SHEET
        }, 500, 18).register(galactifun);

        MachineBlock chemicalReactor = new MachineBlock(CoreItemGroup.MACHINES, CHEMICAL_REACTOR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                BaseMats.SPACE_GRADE_PLATE, null, BaseMats.SPACE_GRADE_PLATE,
                BaseMats.ULTRA_DUTY_SHEET, BaseMats.BLISTERING_VOLCANIC_INGOT, BaseMats.ULTRA_DUTY_SHEET,
                BaseMats.ADVANCED_PROCESSING_UNIT, BaseMats.ULTRA_DUTY_SHEET, BaseMats.ADVANCED_PROCESSING_UNIT
        });

        chemicalReactor.addRecipe(new ItemStack(Material.WATER_BUCKET), Gas.WATER.item(), new ItemStack(Material.BUCKET));
        chemicalReactor.addRecipe(Gas.WATER.item(), Gas.OXYGEN.item(), Gas.HYDROGEN.item().asQuantity(2));

        chemicalReactor.addRecipe(Gas.CARBON_DIOXIDE.item(), SlimefunItems.CARBON, Gas.OXYGEN.item().asQuantity(2));
        chemicalReactor.addRecipe(Gas.METHANE.item(), SlimefunItems.CARBON, Gas.HYDROGEN.item().asQuantity(4));
        chemicalReactor.addRecipe(Gas.HYDROCARBONS.item(), Gas.METHANE.item().asQuantity(6));
        chemicalReactor.addRecipe(SlimefunItems.OIL_BUCKET, Gas.HYDROCARBONS.item(), new ItemStack(Material.BUCKET));

        chemicalReactor.addRecipe(Gas.AMMONIA.item(), Gas.NITROGEN.item(), Gas.HYDROGEN.item().asQuantity(3));

        chemicalReactor.energyCapacity(512);
        chemicalReactor.energyPerTick(128);
        chemicalReactor.ticksPerOutput(20);
        chemicalReactor.register(galactifun);

        new Electrolyzer(ELECTROLYZER, new ItemStack[] {
                BaseMats.SPACE_GRADE_PLATE, null, BaseMats.SPACE_GRADE_PLATE,
                SlimefunItems.SILVER_INGOT, BaseMats.BLISTERING_VOLCANIC_INGOT, SlimefunItems.SILVER_INGOT,
                BaseMats.ADVANCED_PROCESSING_UNIT, BaseMats.ULTRA_DUTY_SHEET, BaseMats.ADVANCED_PROCESSING_UNIT
        }).register(galactifun);

        // relics
        new Relic(BROKEN_SOLAR_PANEL_RELIC, new Relic.RelicSettings()
                .addRequired(SlimefunItems.SILICON, 2, 5)
                .addRequired(SlimefunItems.SOLAR_PANEL, 1, 3)
                .addOptional(SlimefunItems.SOLAR_GENERATOR, 0.20f)
                .addOptional(SlimefunItems.SOLAR_GENERATOR_2, 0.10f)
                .addOptional(SlimefunItems.SOLAR_GENERATOR_3, 0.02f),
                Galactifun.worldManager().alienWorlds().stream()
                        .filter(a -> a.getSetting("generate-fallen-satellites", Boolean.class, true))
                        .toArray(AlienWorld[]::new)).register(galactifun);

        new Relic(FALLEN_SATELLITE_RELIC, new Relic.RelicSettings()
                .addRequired(BaseMats.HEAVY_DUTY_SHEET, 3, 4)
                .addRequired(BaseMats.SPACE_GRADE_PLATE, 1, 3)
                .addRequired(SlimefunItems.BASIC_CIRCUIT_BOARD, 0, 2)
                .addOptional(SlimefunItems.ADVANCED_CIRCUIT_BOARD, 0.15f)
                .addOptional(BaseMats.ADVANCED_PROCESSING_UNIT, 0.10f),
                Galactifun.worldManager().alienWorlds().stream()
                        .filter(a -> a.getSetting("generate-fallen-satellites", Boolean.class, true))
                        .toArray(AlienWorld[]::new)).register(galactifun);

        new TechnologicalSalvager(TECHNOLOGICAL_SALVAGER, new ItemStack[] {
                BaseMats.ULTRA_DUTY_SHEET, null, BaseMats.ULTRA_DUTY_SHEET,
                BaseMats.ADVANCED_PROCESSING_UNIT, null, BaseMats.ADVANCED_PROCESSING_UNIT,
                BaseMats.ULTRA_DUTY_SHEET, new ItemStack(Material.STICKY_PISTON), BaseMats.ULTRA_DUTY_SHEET
        }).register(galactifun);
    }

}
