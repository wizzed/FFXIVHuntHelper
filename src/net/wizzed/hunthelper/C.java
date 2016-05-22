package net.wizzed.hunthelper;

import java.util.ArrayList;

import net.wizzed.hunthelper.model.Coordinate;
import net.wizzed.hunthelper.model.Map;
import net.wizzed.hunthelper.model.Mob;
import net.wizzed.hunthelper.model.Name;
import android.content.Context;

public class C {

	//TODO swipe for next map

	// for preferences
	public static String PREF_NAME = "CENTURIO_HUNT_PREF";
	public static String MOB_NAMES = "MOB_NAMES";
	public static String HIDE_MOBS = "HIDE_MOBS";

	public static String LANG = "LANG";

	// map names
	public static String CWH = "Coerthas Western Highlands";
	public static String TSOC = "The Sea Of Clouds";
	public static String TDF = "The Dravanian Forelands";
	public static String TCM = "The Churning Mists";
	public static String TDH = "The Dravanian Hinterlands";
	public static String AL = "Azys Lla";

	public static ArrayList<Mob> mobList = new ArrayList<Mob>();
	public static ArrayList<Map> mapList = new ArrayList<Map>();

	public static void setupMobsAndMaps(Context ctx) {
		mapList.clear();
		mobList.clear();
		mapList.add(new Map(ctx, CWH, R.drawable.coerthas_western_highlands));
		mapList.add(new Map(ctx, TSOC, R.drawable.the_sea_of_clouds));
		mapList.add(new Map(ctx, TDF, R.drawable.the_dravanian_forelands));
		mapList.add(new Map(ctx, TCM, R.drawable.the_churning_mists));
		mapList.add(new Map(ctx, TDH, R.drawable.the_dravanian_hinterlands));
		mapList.add(new Map(ctx, AL, R.drawable.azys_lla));

		mobList.add(new Mob(CWH, new Name("Archaeornis", "Archaeornis", "Archéornis", "アルケオーニス"), 3, new Coordinate(14, 7))); // 3
		mobList.add(new Mob(CWH, new Name("Bergthurs", "Berg-Jötunn", "Bergthurs", "ベルグスルス"), 2, new Coordinate(32, 24))); // 2
		mobList.add(new Mob(CWH, new Name("Deepeye", "Glotzauge", "Oculus", "ディープアイ"), 3, new Coordinate(30, 32))); // 3
		mobList.add(new Mob(CWH, new Name("Frost Grenade", "Frost-Granate", "Grenado Du Gel", "フロストグレネード"), 2, new Coordinate(28, 12))); // 2
		mobList.add(new Mob(CWH, new Name("Gelato", "Gelato", "Gelato", "ジェラート"), 2, new Coordinate(11, 17))); // 2
		mobList.add(new Mob(CWH, new Name("Ice Commander", "Eiskommandant", "Commandant Gelé", "アイスコマンダー"), 3, new Coordinate(9, 12))); // 3
		mobList.add(new Mob(CWH, new Name("Icetrap", "Eisfalle", "Piège-glace", "アイストラップ"), 3, new Coordinate(23, 16)));
		mobList.add(new Mob(CWH, new Name("Inland Tursus", "Binnen-Tursus", "Tursus Des Terres", "インランド・トゥルスス"), 2, new Coordinate(28, 8)));
		mobList.add(new Mob(CWH, new Name("Lone Yeti", "Einsamer Yeti", "Yéti Solitaire", "ローン・イエティ"), 2, new Coordinate(19, 29))); // 2
		mobList.add(new Mob(CWH, new Name("Polar Bear", "Eisbär", "Ours Polaire", "ポーラーベアー"), 3, new Coordinate(22, 21))); // 3
		mobList.add(new Mob(CWH, new Name("Rheum", "Schlafsand", "Chassie", "ルーム"), 3, new Coordinate(16, 23))); // 3
		mobList.add(new Mob(CWH, new Name("Silver Wolf", "Silberwolf", "Loup Argenté", "シルバーウルフ"), 3, new Coordinate(26, 24)));
		mobList.add(new Mob(CWH, new Name("Slate Yeti", "Schiefer-Yeti", "Yéti Du Grésil", "スレート・イエティ"), -1, new Coordinate(25, 32)));
		mobList.add(new Mob(CWH, new Name("Slush Zoblyn", "Schlamm-Zobalos", "Zoblyn De Névasse", "スラッシュゾブラン"), -1, new Coordinate(25, 11)));
		mobList.add(new Mob(CWH, new Name("Steinbock", "Schneebock", "Steinbock", "スタインボック"), 3, new Coordinate(30, 33)));
		mobList.add(new Mob(CWH, new Name("Upland Mylodon", "Hochland-Mylodon", "Mylodon Des Plateaux", "アップランド・ミロドン"), 3, new Coordinate(31, 20))); // 3
		mobList.add(new Mob(CWH, new Name("Vindthurs", "Vindthur", "Vindthurs", "ヴィンドスルス"), -1, new Coordinate(9, 9)));
		mobList.add(new Mob(CWH, new Name("Wooly Yak", "Woll-Yak", "Yak Laineux", "ウーリーヤク"), 2, new Coordinate(21, 15))); // 2

		mobList.add(new Mob(TSOC, new Name("Anzu", "Anzu", "Anzu", "アンズー"), 2, new Coordinate(21, 6)));
		mobList.add(new Mob(TSOC, new Name("Cloudworm", "Wolkenwurm", "Ver Des Nuages", "クラウドウォーム"), 1, new Coordinate(28, 29))); // 1
		mobList.add(new Mob(TSOC, new Name("Conodont", "Conodont", "Conodonte", "コノドント"), 1, new Coordinate(27, 30))); // 1
		mobList.add(new Mob(TSOC, new Name("Dhalmel", "Dhalmel", "Dhalmel", "ダルメル"), 3, new Coordinate(19, 30))); // 3
		mobList.add(new Mob(TSOC, new Name("Endymion", "Endymion", "Endymion", "エンディミオン"), -1, new Coordinate(17, 10)));
		mobList.add(new Mob(TSOC, new Name("Gaelicat", "Geira-Katze", "Gaélichat", "ゲイラキャット"), 3, new Coordinate(11, 34)));
		mobList.add(new Mob(TSOC, new Name("Gastornis", "Gastornis", "Gastornis", "ガストルニス"), 2, new Coordinate(11, 33))); // 2
		mobList.add(new Mob(TSOC, new Name("Groundskeeper", "Erdwächter", "Terragardien", "グランズキーパー"), 3, new Coordinate(17, 17)));
		mobList.add(new Mob(TSOC, new Name("Korrigan", "Korrigane", "Korrigan", "コリガン"), -1, new Coordinate(20, 30)));
		mobList.add(new Mob(TSOC, new Name("Lan'laii Vundu", "Lan'laii Vundo", "Lan'laii Des Vundu", "ランライ・ブンド"), 1, new Coordinate(28, 10))); // 1
		mobList.add(new Mob(TSOC, new Name("Lan'laii Gundu", "Lan'laii Gundo", "Lan'laii Des Gundu", "ランライ・グンド"), 1, new Coordinate(35, 24))); // 1
		mobList.add(new Mob(TSOC, new Name("Nat'laii Vundu", "Nat'laii Vundo", "Nat'laii Des Vundu", "ナツライ・ブンド"), 1, new Coordinate(28, 9))); // 1
		mobList.add(new Mob(TSOC, new Name("Nat'laii Gundu", "Nat'laii Gundo", "Nat'laii Des Gundu", "ナツライ・グンド"), 1, new Coordinate(36, 20))); // 1
		mobList.add(new Mob(TSOC, new Name("Obdella", "Obdella", "Obdella", "オブデラ"), 2, new Coordinate(29, 29))); // 2
		mobList.add(new Mob(TSOC, new Name("Paissa", "Paissa", "Paissa", "パイッサ"), 3, new Coordinate(20, 34))); // 3
		mobList.add(new Mob(TSOC, new Name("Sanuwa", "Sanuwa", "Sanuwa", "サヌワ"), 1, new Coordinate(35, 22))); // 1
		mobList.add(new Mob(TSOC, new Name("Sanuwa Vundu", "Sanuwa Vundo", "Sanuwa Des Vundu", "サヌワ・ブンド"), -1, new Coordinate(29, 21)));
		mobList.add(new Mob(TSOC, new Name("Toco Toco", "Tokotoko", "Toco Toco", "トコトコ"), 3, new Coordinate(21, 7)));
		mobList.add(new Mob(TSOC, new Name("Tsanahale", "Tsanahal", "Tsanahale", "ツィナハレ"), 2, new Coordinate(14, 7))); // 2
		mobList.add(new Mob(TSOC, new Name("Vuk'laii Gundu", "Vuk'laii Gundo", "Vuk'laii Des Gundu", "ヴクライ・グンド"), 1, new Coordinate(35, 23))); // 1
		mobList.add(new Mob(TSOC, new Name("Vundu Totem", "Vundo-Totem", "Totem Des Vundu", "ブンド・トーテム"), 1, new Coordinate(17, 18))); // 1
		mobList.add(new Mob(TSOC, new Name("Window Wamoura", "Himmelblau-Wamoura", "Wamoura De La Fenêtre Bleue", "ウィンドウ・ワモーラ"), -1, new Coordinate(9, 16)));
		mobList.add(new Mob(TSOC, new Name("Window Wamouracampa", "Himmelblau-Wamouracampa", "Wamouracampa De La Fenêtre Bleue", "ウィンドウ・ワモーラカンパ"), 2, new Coordinate(10, 17)));
		mobList.add(new Mob(TSOC, new Name("Wisent", "Wisent", "Wisent", "ウィセント"), 2, new Coordinate(11, 31)));

		mobList.add(new Mob(TDF, new Name("Bandersnatch", "Bandersnatch", "Bandersnatch", "バンダースナッチ"), 3, new Coordinate(34, 16)));
		mobList.add(new Mob(TDF, new Name("Brown Bear", "Braunbär", "Ours Brun", "ブラウンベアー"), 2, new Coordinate(27, 12)));
		mobList.add(new Mob(TDF, new Name("Clearwater Nanka", "Fluss-Nanka", "Nanka D'eau Douce", "リバー・ナンカ"), -1, new Coordinate(28, 22)));
		mobList.add(new Mob(TDF, new Name("Clearwater Ninki Nanka", "Fluss-Ninki Nanka", "Ninki Nanka D'eau Douce", "リバー・ニンキナンカ"), 2, new Coordinate(27, 25))); // 2
		mobList.add(new Mob(TDF, new Name("Dragonfly Watcher", "Späher-Drachycera", "Draguêpe Veilleur", "ドラゴンフライ・ウォッチャー"), 2, new Coordinate(28, 32)));
		mobList.add(new Mob(TDF, new Name("Dravanian Aevis", "Dravanischer Avis", "Eibis Dravanien", "ドラヴァニアン・エイビス"), 2, new Coordinate(26, 22))); // 2
		mobList.add(new Mob(TDF, new Name("Dravanian Wyvern", "Dravanischer Wyvern", "Wyverne Dravanienne", "ドラヴァニアン・ワイバーン"), 3, new Coordinate(16, 33)));
		mobList.add(new Mob(TDF, new Name("Wild Chocobo", "Wild-Chocobo", "Chocobo Sauvage", "ワイルドチョコボ"), 3, new Coordinate(38, 19)));
		mobList.add(new Mob(TDF, new Name("Feather Flea", "Fiederfloh", "Puce à Plumes", "フェザーフリー"), 3, new Coordinate(36, 24)));
		mobList.add(new Mob(TDF, new Name("Forelands Hippocerf", "Vorland-Hippocerf", "Hippocerf De L'avant-pays", "フォーランド・ヒッポセルフ"), 3, new Coordinate(17, 26)));
		mobList.add(new Mob(TDF, new Name("Gallimimus", "Gallimimus", "Gallimimus", "ガッリミムス"), 3, new Coordinate(23, 11)));
		mobList.add(new Mob(TDF, new Name("Gnath Firedrone", "Loth-Feuerdrohne", "Gnathe Myrmifeu", "グナース・ファイアドローン"), 1, new Coordinate(27, 37)));
		mobList.add(new Mob(TDF, new Name("Gnath Steeldrone", "Gnath-Stahldrohne", "Gnathe Myrmacier", "グナース・スチールドローン"), 1, new Coordinate(27, 38)));
		mobList.add(new Mob(TDF, new Name("Loaghtan", "Loaghtan", "Loaghtan", "ロフタン"), 3, new Coordinate(25, 29)));
		mobList.add(new Mob(TDF, new Name("Melia", "Meliade", "Mélia", "メリアエ"), 2, new Coordinate(23, 26))); // 2
		mobList.add(new Mob(TDF, new Name("Miacid", "Miacis", "Miacis", "ミアキス"), 3, new Coordinate(18, 27))); // 3
		mobList.add(new Mob(TDF, new Name("Syricta", "Syricta", "Syricta", "シリクタ"), 2, new Coordinate(18, 12)));
		mobList.add(new Mob(TDF, new Name("Thunder Dragon", "Blitzdrache", "Dragon De Foudre", "サンダードラゴン"), 1, new Coordinate(31, 8))); // 1
		mobList.add(new Mob(TDF, new Name("Tyrannosaur", "Tyrannosaurus", "Tyrannosaure", "ティラノサウルス"), 2, new Coordinate(13, 15))); // 2
		mobList.add(new Mob(TDF, new Name("Vinegaroon", "Geißelskorpion", "Vinaigrier", "ビネガロン"), 2, new Coordinate(18, 12))); // 2
		mobList.add(new Mob(TDF, new Name("Gnath Cultivator", "Loth-Kultivator", "Gnathe Cultivateur", "ロス・カルティベーター"), 1, new Coordinate(28, 36))); // 1

		mobList.add(new Mob(TCM, new Name("Amphiptere", "Amphitere", "Amphiptère", "アンフィプテレ"), 2, new Coordinate(17, 27)));
		mobList.add(new Mob(TCM, new Name("Archaeosaur", "Archaeosaurus", "Archéosaure", "アルケオダイノス"), -1, new Coordinate(24, 26)));
		mobList.add(new Mob(TCM, new Name("Bladed Vinegaroon", "Klingen-Geißelskorpion", "Vinaigrier à Lames", "ブレード・ビネガロン"), 2, new Coordinate(13, 24))); // 2
		mobList.add(new Mob(TCM, new Name("Blood Dragon", "Blutdrache", "Dragon De Sang", "ブラッドドラゴン"), 1, new Coordinate(25, 10))); // 1
		mobList.add(new Mob(TCM, new Name("Cloud Aevis", "Wolken-Avis", "Nubeibis", "クラウドエイビス"), 1, new Coordinate(9, 36))); // 1
		mobList.add(new Mob(TCM, new Name("Diresaur", "Werdrache", "Allosaure", "ウェアドラゴン"), 3, new Coordinate(11, 9)));
		mobList.add(new Mob(TCM, new Name("Dragonet", "Leierfisch", "Dragonnet", "ドラゴネット"), 3, new Coordinate(20, 12)));
		mobList.add(new Mob(TCM, new Name("Elder Syricta", "Höherer Syricta", "Syricta Antique", "エルダーシリクタ"), 2, new Coordinate(34, 21))); // 2
		mobList.add(new Mob(TCM, new Name("Elder Wyvern", "Höherer Wyvern", "Wyverne Ancienne", "エルダーワイバーン"), -1, new Coordinate(25, 30)));
		mobList.add(new Mob(TCM, new Name("Gnarled Melia", "Knorrige Meliade", "Mélia Noueuse", "ナールド・メリアエ"), -1, new Coordinate(10, 20)));
		mobList.add(new Mob(TCM, new Name("Hropken", "Hropken", "Hropken", "ロプケン"), 2, new Coordinate(34, 28))); // 2
		mobList.add(new Mob(TCM, new Name("Limestone Golem", "Kalkstein-Golem", "Golem De Calcaire", "ライムゴーレム"), 2, new Coordinate(9, 12))); // 2
		mobList.add(new Mob(TCM, new Name("Lower Skylord", "Niederer Drache", "Maître Aérien Mineur", "レッサードラゴン"), 2, new Coordinate(20, 28))); // 2
		mobList.add(new Mob(TCM, new Name("Mists Biast", "Nebel-Smei", "Biast Des Brumes", "ミスト・ビアスト"), 2, new Coordinate(33, 31)));
		mobList.add(new Mob(TCM, new Name("Mists Drake", "Nebel-Drakon", "Dragon Des Brumes", "ミスト・ドレイク"), 3, new Coordinate(10, 18))); // 3
		mobList.add(new Mob(TCM, new Name("Moss Dragon", "Moosdrache", "Dragon Moussu", "モスドラゴン"), 2, new Coordinate(23, 25))); // 2
		mobList.add(new Mob(TCM, new Name("Sankchinni", "Sankchinni", "Sankchinni", "サンクチンニ"), 3, new Coordinate(26, 31)));
		mobList.add(new Mob(TCM, new Name("Tulihand", "Tulihand", "Tulihänd", "トゥリヘンド"), 2, new Coordinate(32, 15))); // 2
		mobList.add(new Mob(TCM, new Name("Vouivre", "Vivel", "Vouivre", "ヴィーヴル"), 2, new Coordinate(37, 18))); // 2
		mobList.add(new Mob(TCM, new Name("Wadjet", "Wadjet", "Ouadjet", "ウアジェット"), 2, new Coordinate(26, 20))); // 2

		mobList.add(new Mob(TDH, new Name("Bifericeras", "Bifericeras", "Biféricéras", "ビフェリケラス"), 3, new Coordinate(26, 37)));
		mobList.add(new Mob(TDH, new Name("Cockatrice", "Cockatrice", "Cocatrix", "コカトリス"), 3, new Coordinate(18, 36)));
		mobList.add(new Mob(TDH, new Name("Crawler", "Kriecher", "Chenille", "クロウラー"), 3, new Coordinate(12, 16)));
		mobList.add(new Mob(TDH, new Name("Damselfly", "Kleinlibelle", "Demoiselle", "ダムゼルフライ"), 2, new Coordinate(24, 21))); // 2
		mobList.add(new Mob(TDH, new Name("Goblin Brandisher", "Goblin-Schleuderer", "Brandisseur Gobelin", "ゴブリン・ブランディッシャー"), 1, new Coordinate(31, 21)));
		mobList.add(new Mob(TDH, new Name("Goblin Sharpshooter", "Goblin-Scharfschütze", "Tireur Gobelin", "ゴブリン・シャープシューター"), 2, new Coordinate(31, 22))); // 2
		mobList.add(new Mob(TDH, new Name("Goblin Tinkerer", "Goblin-Bastler", "Rétameur Gobelin", "ゴブリン・ティンカラー"), -1, new Coordinate(31, 23)));
		mobList.add(new Mob(TDH, new Name("Great Morbol", "Groß-Morbol", "Grand Morbol", "モルボルグレート"), 1, new Coordinate(10, 21)));
		mobList.add(new Mob(TDH, new Name("Narbrooi", "Narbrooi", "Narbrooi", "ナルブルーイ"), 3, new Coordinate(37, 24))); // 3
		mobList.add(new Mob(TDH, new Name("Okeanis", "Okeanis", "Océanide", "オーケアニス"), 2, new Coordinate(9, 30)));
		mobList.add(new Mob(TDH, new Name("Opken", "Opken", "Opken", "オプケン"), 3, new Coordinate(12, 33)));
		mobList.add(new Mob(TDH, new Name("Orn Kite", "Orn-Kolibri", "Colibri D'Orn", "オーン・コリブリ"), 3, new Coordinate(11, 27)));
		mobList.add(new Mob(TDH, new Name("Poroggo", "Poroggo", "Poroggo", "ポロッゴ"), 2, new Coordinate(9, 34)));
		mobList.add(new Mob(TDH, new Name("Ratel", "Ratel", "Ratel", "ラーテル"), 2, new Coordinate(28, 27))); // 2
		mobList.add(new Mob(TDH, new Name("Sun Leech", "Sonnen-Egel", "Sangsue Solaire", "サンリーチ"), 2, new Coordinate(9, 31))); // 2
		mobList.add(new Mob(TDH, new Name("Tarantula Hawk", "Tarantulafalke", "Guêpe Pepsis", "タランチュラホーク"), 3, new Coordinate(21, 16))); // 3
		mobList.add(new Mob(TDH, new Name("Wildebeest", "Gnu", "Gnou", "ワイルドビースト"), 3, new Coordinate(36, 28))); // 3

		mobList.add(new Mob(AL, new Name("6th Legion Vanguard", "Frontbrecher der VI. Legion", "Avant-garde De La 6e Légion", "VIレギオン・ヴァンガード"), -1, new Coordinate(35, 24)));
		mobList.add(new Mob(AL, new Name("Adamantite Claw", "Magitek-Adamantiumklaue", "Griffe D'adamantium Magitek", "魔導アダマンクロー"), -1, new Coordinate(27, 33)));
		mobList.add(new Mob(AL, new Name("Allagan Chimera", "Allagische Chimära", "Chimère Allagoise", "アラガン・キマイラ"), 1, new Coordinate(31, 6)));
		mobList.add(new Mob(AL, new Name("Corpse Flower", "Titanenwurz", "Fleur-dépouille", "コープスフラワー"), 2, new Coordinate(30, 12))); // 2
		mobList.add(new Mob(AL, new Name("Clockwork Engineer", "Uhrwerk-Techniker", "Ingénieur Mécanique", "アラガンワーク・エンジニア"), 1, new Coordinate(17, 13)));
		mobList.add(new Mob(AL, new Name("Clockwork Harvestman", "Uhrwerk-Ernter", "Faucheux Mécanique", "アラガンワーク・ハーベストマン"), 3, new Coordinate(13, 9))); // 3
		mobList.add(new Mob(AL, new Name("Clockwork Paladin", "Uhrwerk-Paladin", "Paladin Mécanique", "アラガンワーク・パラディン"), 1, new Coordinate(20, 10)));
		mobList.add(new Mob(AL, new Name("Empuse", "Empusa", "Empousa", "エンプーサ"), 2, new Coordinate(31, 11)));
		mobList.add(new Mob(AL, new Name("Enforcement Droid", "Vollzugsdroide", "Droide D'exécution", "エンフォースドロイド"), 3, new Coordinate(13, 15)));
		mobList.add(new Mob(AL, new Name("Lamia Cybrid", "Lamia-Zybrid", "Lamia Cybride", "ラミア・サイブリッド"), 1, new Coordinate(27, 11))); // 1
		mobList.add(new Mob(AL, new Name("Lamia Thelytoke", "Lamia-Thelytokie", "Lamia Thélitoque", "ラミア・テリトーク"), 1, new Coordinate(28, 14))); // 1
		mobList.add(new Mob(AL, new Name("Lesser Hydra", "Kleine Hydra", "Hydre Mineure", "レッサーハイドラ"), -1, new Coordinate(13, 33)));
		mobList.add(new Mob(AL, new Name("Meracydian Amphiptere", "Meracydischer Amphitere", "Amphiptère Méracydien", "メラシディアン・アンフィプテレ"), -1, new Coordinate(18, 31)));
		mobList.add(new Mob(AL, new Name("Meracydian Brobynyak", "Meracydischer Brobinyak", "Brobinyak Méracydien", "メラシディアン・ブロビニャク"), -1, new Coordinate(8, 31)));
		mobList.add(new Mob(AL, new Name("Meracydian Dragon", "Meracydischer Drache", "Dragon Méracydien", "メラシディアン・ドラゴン"), -1, new Coordinate(8, 27)));
		mobList.add(new Mob(AL, new Name("Meracydian Dragonet", "Meracydischer Leierfisch", "Dragonnet Méracydien", "メラシディアン・ドラゴネット"), -1, new Coordinate(6, 35)));
		mobList.add(new Mob(AL, new Name("Meracydian Vouivre", "Meracydische Vivel", "Vouivre Méracydienne", "メラシディアン・ヴィーヴル"), 1, new Coordinate(10, 37)));
		mobList.add(new Mob(AL, new Name("Proto-naga", "Proto-Naga", "Proto-Naga", "プロト・ナーガ"), 2, new Coordinate(35, 8)));
		mobList.add(new Mob(AL, new Name("Reptoid", "Reptoid", "Reptoide", "レプトイド"), 2, new Coordinate(33, 13)));
		mobList.add(new Mob(AL, new Name("Snapper-rook", "Schnappturm", "Drone-drille", "ルークスナッパー"), 2, new Coordinate(9, 12)));
		mobList.add(new Mob(AL, new Name("Owlbear", "Strigidae", "Hibours", "オウルベア"), 3, new Coordinate(12, 15)));
		mobList.add(new Mob(AL, new Name("Meracydian Falak", "Meracydischer Falak", "Falak Méracydien", "メラシディアン・ファラク"), 1, new Coordinate(15, 29))); // 1

	}
}
