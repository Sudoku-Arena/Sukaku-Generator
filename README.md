## Mode d'emploi : Utilisation de la boîte de dialogue "Generate" (GenerateDialog)

Ce document décrit comment utiliser la boîte de dialogue de génération ("Generate") incluse dans Sukaku Explainer
pour créer un ou plusieurs Sudokus et, si souhaité, les enregistrer dans un fichier.

Remarque : ce guide se concentre uniquement sur l'interface de génération. Pour des informations générales sur
Sukaku Explainer (installation, builds, exécution), référez‑vous aux documents principaux du projet.

---

### Lancer l'application

- Si vous avez un fichier JAR prêt (`SukakuExplainer.jar`), lancez la GUI avec :

```powershell
java -jar SukakuExplainer.jar
```

- Si vous travaillez depuis les sources dans un IDE (NetBeans, IntelliJ, Eclipse), ouvrez le projet et lancez la classe principale
  (le lanceur de l'interface graphique). La fenêtre principale contient le menu pour ouvrir la boîte de dialogue de génération.

---

### Ouvrir la boîte de dialogue Generate

Dans la fenêtre principale de Sukaku Explainer, choisissez le menu "Generate" (ou "Generate a random Sudoku") pour ouvrir la boîte de dialogue
de génération. C'est l'interface qui permet de configurer les paramètres et de lancer la génération.

---

### Présentation des options principales

- Allowed symmetry types : cochez les types de symétrie que vous autorisez pour la grille générée (p. ex. Orthogonal,
  BiDiagonal, Rotational90, Rotational180, Full). Au moins une symétrie doit être sélectionnée.

- Difficulty (Difficulté) : choisissez une plage de difficulté prédéfinie (Easy, Medium, Hard, Superior, ...).

  - "Exact difficulty" : la génération vise la valeur choisie.
  - "Maximum difficulty" : la génération accepte toute difficulté inférieure ou égale à la valeur choisie.
    La description du niveau s'affiche dans la zone "Description".

- Show the analysis of the generated Sudoku (case à cocher) : si activée, une fois le Sudoku généré,
  l'analyse (difficulty rating / techniques) sera affichée dans la fenêtre principale.

---

### Nouvelles options : génération par lot, format SER et enregistrement

La boîte de dialogue a été enrichie : generation en lot, choix de format d'export et une barre de progression sont désormais disponibles.

- Count : nombre de Sudokus à générer (spinner). Entrez le nombre de grilles que vous souhaitez créer.

- Save to file (case à cocher) : cochez pour écrire chaque grille dans un fichier de sortie. Lorsque cette option est cochée, le champ "Out file" et le sélecteur "Format" sont activés.

- Out file (champ + Browse...) : chemin du fichier de sortie. Cliquez sur Browse... pour choisir/creer le fichier.
  Le champ a été rendu plus compact dans l'interface (champ plus court) et les contrôles d'export sont maintenant empilés pour éviter d'élargir inutilement la fenêtre.

- Format (nouveau) : choisissez le format d'écriture dans le fichier. Deux options sont disponibles :
  - "Classique" : une ligne par puzzle, 81 caractères (1..9 ou `.` pour case vide), ordre : ligne 1 puis ligne 2, ... ligne 9.
  - "SER" : format SER (utilisé par certains outils) : la ligne contient la grille (81 caractères) suivie d'un espace puis d'un rating (ex. : `..53... 3.4`). Le rating est calculé via le solver intégré et peut ralentir légèrement la génération car chaque grille est analysée pour obtenir la notation.

Fonctionnement :

- Si "Save to file" est activé, chaque grille générée est écrite en append dans le fichier indiqué.
- Si vous choisissez "SER", la génération déclenche aussi une analyse par le solver pour calculer la note (rating). Cela peut augmenter le temps de génération surtout en batch.

Note : l'écriture se fait en mode append (ajoute à la fin du fichier). Si vous préférez écraser le fichier, supprimez/renommez le fichier avant génération.

---

### Barre de progression et navigation

- Pendant la génération en lot, une barre de progression s'affiche et montre le nombre de grilles générées sur le nombre total demandé (ex. "3 / 10").
- Le bouton "Generate" devient "Stop" pendant l'exécution pour interrompre la génération en cours.
- Les grilles générées sont ajoutées à la liste interne et vous pouvez naviguer entre elles avec `<` et `>` pendant et après la génération.

---

### Lancer la génération (récapitulatif)

1. Sélectionnez les symétries et la difficulté souhaitées.
2. (Optionnel) Choisissez le nombre de Sudokus (`Count`).
3. (Optionnel) Cochez "Save to file", choisissez un fichier de sortie et le format (Classique ou SER).
4. Cliquez sur "Generate".
   - Pendant la génération, le bouton devient "Stop" et la fenêtre affiche la barre de progression.
   - Si vous générez plusieurs grilles, le programme itère et ajoute chaque grille au buffer d'affichage.

---

### Interruption et navigation

- Bouton "Stop" : arrête la génération en cours. Les grilles déjà générées restent dans la liste et, si demandé, ont déjà été écrites dans le fichier.
- Boutons `<` et `>` : permettent de naviguer entre les grilles générées durant la session.

---

### Conseils et dépannage

- La génération peut être lente selon les paramètres (difficulté élevée, contraintes de techniques spécifiques). La génération en mode SER est plus lente car chaque grille est analysée pour produire la note.
- Si la génération semble ne pas progresser, vérifiez dans `Settings` que les techniques minimales nécessaires sont activées (la boîte de dialogue vous avertit si certaines techniques ne le sont pas).
- Si vous souhaitez des grilles avec solution unique garantie plus strictement, activez les techniques/paramètres correspondants dans `Settings` ou procédez à une vérification via le solver avant d'écrire (option avancée non automatique).

---

### Format de sortie (rappel)

- Classique : chaque ligne du fichier de sortie correspond à un puzzle. Chaque caractère représente une case (1..9 ou `.` pour vide), ordre : ligne 1 (colonnes 1..9), ligne 2, ... ligne 9.
- SER : une ligne par puzzle, la grille (81 caractères), un espace, puis la note (float avec une décimale). Exemple :

```
..53... (81 chars) 3.4
```

---

Si vous voulez que je change le format d'export (par exemple : fichier "pretty" avec 9 lignes par grille, JSON, CSV, option d'overwrite au lieu d'append, ou d'autres formats de notation), dites‑le et je l'ajoute.

Bonne génération !
