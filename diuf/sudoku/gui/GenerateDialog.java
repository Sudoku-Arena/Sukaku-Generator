/*
 * Project: Sudoku Explainer
 * Copyright (C) 2006-2007 Nicolas Juillerat
 * Available under the terms of the Lesser General Public License (LGPL)
 */
package diuf.sudoku.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.*;
import java.io.*;

import diuf.sudoku.*;
import diuf.sudoku.generator.*;
import diuf.sudoku.solver.*;
import diuf.sudoku.tools.*;


//Controlling difficulty of hidden set
//New changes
public class GenerateDialog extends JDialog {

    private static final long serialVersionUID = 8620081149465721387L;

    private enum Difficulty {
        Easy {

            @Override
            public double getMinDifficulty() {
                return 1.0;
            }

            @Override
            public double getMaxDifficulty() {
                return 1.2;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
            @Override
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
        Medium {

            @Override
            public double getMinDifficulty() {
                return 1.3;
            }

            @Override
            public double getMaxDifficulty() {
                return 1.6;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
            @Override
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
        Hard {

            @Override
            public double getMinDifficulty() {
                return 1.7;
            }

            @Override
            public double getMaxDifficulty() {
                return 2.5;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
			}
            @Override
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
            }
			public String getincludeTechnique1() {
				return "";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
        Superior {

            @Override
            public double getMinDifficulty() {
				if (Settings.getInstance().revisedRating() == 1)
					return 3.1;
				return 3.2;
            }

            @Override
            public double getMaxDifficulty() {
				if (Settings.getInstance().revisedRating() == 1)
					return 3.8;
                return 4.0;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
				if (Settings.getInstance().revisedRating() == 1)
					return 0.0;
                return 3.8;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
				if (Settings.getInstance().revisedRating() == 1)
					return 0.0;
                return 3.4;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
            @Override
			public String getexcludeTechnique1() {
				return "Skyscraper";
			}
            @Override
			public String getexcludeTechnique2() {
				return "2-String Kite";
			}
            @Override
			public String getexcludeTechnique3() {
				return "Turbot Fish";
			}
			public String getincludeTechnique1() {
				return "";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "Triple";
			}
            @Override
			public String getOneOfThree_2() {
				return "X-Wing";
			}
            @Override
			public String getOneOfThree_3() {
				return "X-Wing";
			}
        },
        Fiendish {

            @Override
            public double getMinDifficulty() {
                return 2.6;
            }

            @Override
            public double getMaxDifficulty() {
                return 6.0;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
        Fiendish2 {

            @Override
            public double getMinDifficulty() {
                return 3.0;
            }

            @Override
            public double getMaxDifficulty() {
                return 7.0;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "Forcing";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
		SuperiorPlus {

            @Override
            public double getMinDifficulty() {
				if (Settings.getInstance().revisedRating() == 1)
					return 4.0;
                return 3.8;
            }

            @Override
            public double getMaxDifficulty() {
                return 6.1;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                if (Settings.getInstance().revisedRating() == 1)
					return 0.0;
				return 4.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "XY";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
		XYorXYZ {

            @Override
            public double getMinDifficulty() {
                return 4.2;
            }

            @Override
            public double getMaxDifficulty() {
                return 4.4;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "XY";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
		TwoStringKite {

            @Override
            public double getMinDifficulty() {
                return 4.1;
            }

            @Override
            public double getMaxDifficulty() {
                return 4.1;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "Skyscraper";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
		EmptyRectangle {

            @Override
            public double getMinDifficulty() {
                return 4.3;
            }

            @Override
            public double getMaxDifficulty() {
                return 4.3;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "Skyscraper";
			}
            @Override
			public String getexcludeTechnique2() {
				return "Kite";
			}
            @Override
			public String getexcludeTechnique3() {
				return "XY";
			}
			public String getincludeTechnique1() {
				return "Empty Rectangle";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
		Grouped2StrongLinks {

            @Override
            public double getMinDifficulty() {
                return 4.3;
            }

            @Override
            public double getMaxDifficulty() {
                return 4.3;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "XY";
			}
			public String getincludeTechnique1() {
				return "11";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
		XLoop {

            @Override
            public double getMinDifficulty() {
                return 4.0;
            }

            @Override
            public double getMaxDifficulty() {
                return 6.6;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "X-Loop";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
		gXLoop {

            @Override
            public double getMinDifficulty() {
                return 4.0;
            }

            @Override
            public double getMaxDifficulty() {
                return 6.6;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "(2 Strong Links) Grouped X-Loop 2";
			}
            @Override
			public String getOneOfThree_2() {
				return "(3 Strong Links) Grouped X-Loop 3";
			}
            @Override
			public String getOneOfThree_3() {
				return "(4 Strong Links) Grouped X-Loop 4";
			}
        },
		ThreeStrongLinks {

            @Override
            public double getMinDifficulty() {
                return 5.4;
            }

            @Override
            public double getMaxDifficulty() {
                return 5.7;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return " 10";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
		ThreeLinkER {

            @Override
            public double getMinDifficulty() {
                return 5.7;
            }

            @Override
            public double getMaxDifficulty() {
                return 5.7;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "2-";
			}
			public String getincludeTechnique1() {
				return "";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "Wing 2";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "type 2";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return " 30";
			}
            @Override
			public String getOneOfThree_2() {
				return " 31";
			}
            @Override
			public String getOneOfThree_3() {
				return " 2";
			}
        },
		/*ThreeLinkEmL {

            @Override
            public double getMinDifficulty() {
                return 5.7;
            }

            @Override
            public double getMaxDifficulty() {
                return 5.7;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "";
			}
            @Override
			public String getincludeTechnique2() {
				return "EmL";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
		*/
		FourLinks {

            @Override
            public double getMinDifficulty() {
                return 5.8;
            }

            @Override
            public double getMaxDifficulty() {
                return 6.1;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "4-";
			}
            @Override
			public String getOneOfThree_2() {
				return "4 S";
			}
            @Override
			public String getOneOfThree_3() {
				return "4 S";
			}
        },
		WXYZ {

            @Override
            public double getMinDifficulty() {
                return 5.5;
            }

            @Override
            public double getMaxDifficulty() {
                return 5.6;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "Wing 2";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
		Uniqueness {

            @Override
            public double getMinDifficulty() {
                return 4.5;
            }

            @Override
            public double getMaxDifficulty() {
                return 5.3;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "Unique";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
		UL10 {
            @Override
            public double getMinDifficulty() {
				if (Settings.getInstance().revisedRating() == 1)
					return 4.8;
                return 5.0;
            }

            @Override
            public double getMaxDifficulty() {
				if (Settings.getInstance().revisedRating() == 1)
					return 5.1;
                return 5.3;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
            @Override
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "Unique Loop 10";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				if (Settings.getInstance().revisedRating() == 1)
					return "Naked";
				return "Jellyfish";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
		},
		UniquenessType3 {
            @Override
            public double getMinDifficulty() {
				if (Settings.getInstance().revisedRating() == 1)
					return 4.6;
                return 4.5;
            }

            @Override
            public double getMaxDifficulty() {
				if (Settings.getInstance().revisedRating() == 1)
					return 5.3;
                return 5.3;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
            @Override
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "Unique";
			}
            @Override
			public String getincludeTechnique2() {
				return "type 3";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				if (Settings.getInstance().revisedRating() == 1)
					return "Naked";
				return "Jellyfish";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
		},
		UL12Type3 {
            @Override
            public double getMinDifficulty() {
				if (Settings.getInstance().revisedRating() == 1)
					return 4.9;
                return 5.0;
            }

            @Override
            public double getMaxDifficulty() {
				if (Settings.getInstance().revisedRating() == 1)
					return 5.2;
                return 5.3;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
            @Override
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "Unique Loop 12 type 3";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				if (Settings.getInstance().revisedRating() == 1)
					return "Naked";
				return "Jellyfish";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
		},
		Quintuplet {

            @Override
            public double getMinDifficulty() {
                return 5.6;
            }

            @Override
            public double getMaxDifficulty() {
                return 6.8;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "Quintuplet";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
		APE {

            @Override
            public double getMinDifficulty() {
                return 6.2;
            }

            @Override
            public double getMaxDifficulty() {
                return 6.2;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "ligned";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
		BUGs {

            @Override
            public double getMinDifficulty() {
                return 5.6;
            }

            @Override
            public double getMaxDifficulty() {
                return 6.1;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "BUG";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
		VWXYZ {

            @Override
            public double getMinDifficulty() {
                return 6.2;
            }

            @Override
            public double getMaxDifficulty() {
                return 6.4;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "VWXYZ-Wing 2";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
		UVWXYZ {

            @Override
            public double getMinDifficulty() {
                return 6.6;
            }

            @Override
            public double getMaxDifficulty() {
                return 6.6;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "UVWXYZ-Wing 2";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
		TUVWXYZ {

            @Override
            public double getMinDifficulty() {
                return 7.5;
            }

            @Override
            public double getMaxDifficulty() {
                return 7.5;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "Chain";
			}
            @Override
			public String getexcludeTechnique2() {
				return "Aligned";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "TUVWXYZ-Wing 2";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
		FiveLinks {

            @Override
            public double getMinDifficulty() {
                return 6.2;
            }

            @Override
            public double getMaxDifficulty() {
                return 6.5;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "5-";
			}
            @Override
			public String getOneOfThree_2() {
				return "5 S";
			}
            @Override
			public String getOneOfThree_3() {
				return "5 S";
			}
        },
		SixLinks {

            @Override
            public double getMinDifficulty() {
                return 6.6;
            }

            @Override
            public double getMaxDifficulty() {
                return 6.9;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "6-";
			}
            @Override
			public String getOneOfThree_2() {
				return "6 S";
			}
            @Override
			public String getOneOfThree_3() {
				return "6 S";
			}
        },
		AdvancedPlayer {

            @Override
            public double getMinDifficulty() {
                return 7.0;
            }

            @Override
            public double getMaxDifficulty() {
                return 8.0;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
 		DailySudoku {

            @Override
            public double getMinDifficulty() {
                return 7.1;
            }

            @Override
            public double getMaxDifficulty() {
                return 7.2;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "Kite";
			}
            @Override
			public String getexcludeTechnique2() {
				return "XY";
			}
            @Override
			public String getexcludeTechnique3() {
				return "Strong";
			}
			public String getincludeTechnique1() {
				return "Forcing Chain";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        },
		Diabolical {

            @Override
            public double getMinDifficulty() {
                return 6.1;
            }

            @Override
            public double getMaxDifficulty() {
                return 11.0;
            }
            @Override
            public double getincludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getincludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty1() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty2() {
                return 0.0;
            }
            @Override
            public double getexcludeDifficulty3() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty1() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty2() {
                return 0.0;
            }
            @Override
            public double getnotMaxDifficulty3() {
                return 0.0;
            }
			public String getexcludeTechnique1() {
				return "";
			}
            @Override
			public String getexcludeTechnique2() {
				return "";
			}
            @Override
			public String getexcludeTechnique3() {
				return "";
			}
			public String getincludeTechnique1() {
				return "";
			}
            @Override
			public String getincludeTechnique2() {
				return "";
			}
            @Override
			public String getincludeTechnique3() {
				return "";
			}
			public String getnotMaxTechnique1() {
				return "";
			}
            @Override
			public String getnotMaxTechnique2() {
				return "";
			}
            @Override
			public String getnotMaxTechnique3() {
				return "";
			}
            @Override
			public String getOneOfThree_1() {
				return "";
			}
            @Override
			public String getOneOfThree_2() {
				return "";
			}
            @Override
			public String getOneOfThree_3() {
				return "";
			}
        };

        public abstract double getMinDifficulty();
        public abstract double getMaxDifficulty();
		public abstract double getincludeDifficulty1();
		public abstract double getincludeDifficulty2();
		public abstract double getincludeDifficulty3();
		public abstract double getexcludeDifficulty1();
		public abstract double getexcludeDifficulty2();
		public abstract double getexcludeDifficulty3();
		public abstract double getnotMaxDifficulty1();
		public abstract double getnotMaxDifficulty2();
		public abstract double getnotMaxDifficulty3();
		public abstract String getexcludeTechnique1();
		public abstract String getexcludeTechnique2();
		public abstract String getexcludeTechnique3();
		public abstract String getincludeTechnique1();
		public abstract String getincludeTechnique2();
		public abstract String getincludeTechnique3();
		public abstract String getnotMaxTechnique1();
		public abstract String getnotMaxTechnique2();
		public abstract String getnotMaxTechnique3();
		public abstract String getOneOfThree_1();
 		public abstract String getOneOfThree_2();
		public abstract String getOneOfThree_3();
       public String getHtmlDescription() {
            return HtmlLoader.loadHtml(this, this.name() + ".html");
        }

    }


    private final SudokuExplainer engine;
    private JButton btnGenerate;
    private JButton btnNext;
    private JButton btnPrev;
    private JLabel lblDifficulty;
    private JCheckBox chkAnalysis;

    // Multiple generation / export controls
    private JSpinner spinnerCount;
    private JCheckBox chkSaveToFile;
    private JTextField txtOutFile;
    private JButton btnBrowseOut;
    private JComboBox<String> comboFormat;
    private String selectedFormat = "Classique";
    private JProgressBar progressBar;

    private EnumSet<Symmetry> symmetries = EnumSet.noneOf(Symmetry.class);
    private Difficulty difficulty = Difficulty.Easy;
    private boolean isExact = true;

    private GeneratorThread generator = null;
    private List<Grid> sudokuList = new ArrayList<Grid>();
    private int sudokuIndex = 0;
    private Map<Grid, Hint> sudokuAnalyses = new HashMap<Grid, Hint>();


    public GenerateDialog(JFrame owner, SudokuExplainer engine) {
        super(owner, false);
        this.engine = engine;
        initParameters();
        initGUI();
    }

    private void initParameters() {
        symmetries.add(Symmetry.Orthogonal);
        symmetries.add(Symmetry.BiDiagonal);
        symmetries.add(Symmetry.Rotational180);
        symmetries.add(Symmetry.Rotational90);
        symmetries.add(Symmetry.Full);

        sudokuList.add(engine.getGrid());
    }

    private boolean isTechniqueSetSafe() {
        Settings settings = Settings.getInstance();
        if (!settings.getTechniques().contains(SolvingTechnique.HiddenSingle))
            return false;
        if (!settings.isUsingOneOf(SolvingTechnique.DirectPointing))
            return false;
        if (!settings.isusingAll(SolvingTechnique.PointingClaiming,
                SolvingTechnique.HiddenPair, SolvingTechnique.NakedPair,
                SolvingTechnique.XWing))
            return false;
        if (!settings.isUsingOneOf(SolvingTechnique.ForcingChainCycle))
            return false;
        return true;
    }

    private void initGUI() {
        // This
        setTitle("Generate a random Sudoku");
        setResizable(false);

        // Overall layout
        getContentPane().setLayout(new BorderLayout());
        JPanel paramPanel = new JPanel();
        JPanel commandPanel = new JPanel();
        getContentPane().add(paramPanel, BorderLayout.CENTER);
        getContentPane().add(commandPanel, BorderLayout.SOUTH);

        // Command pane
        commandPanel.setLayout(new GridLayout(1, 2));
        JPanel pnlGenerate = new JPanel();
        pnlGenerate.setLayout(new FlowLayout(FlowLayout.CENTER));
        commandPanel.add(pnlGenerate);
        JPanel pnlClose = new JPanel();
        pnlClose.setLayout(new FlowLayout(FlowLayout.CENTER));
        commandPanel.add(pnlClose);

        btnPrev = new JButton();
        btnPrev.setText("<");
        btnPrev.setEnabled(false);
        btnPrev.setMnemonic(KeyEvent.VK_LEFT);
        btnPrev.setToolTipText("Restore the previous Sudoku");
        btnPrev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                prev();
            }
        });
        pnlGenerate.add(btnPrev);
        btnGenerate = new JButton();
        btnGenerate.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 12));
        btnGenerate.setText("Generate");
        btnGenerate.setMnemonic(KeyEvent.VK_G);
        btnGenerate.setToolTipText("Generate a new random Sudoku that matches the given parameters");
        btnGenerate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (generator == null) {
                    if (!isTechniqueSetSafe()) {
                        int result = JOptionPane.showConfirmDialog(
                                GenerateDialog.this,
                                "<html><body>" +
                                "<b>Warning</b>: not all solving techniques are enabled.<br>" +
                                "The Sudoku Explainer may not be able to generate<br>" +
                                "a Sudoku with the selected parameters (it may loop<br>" +
                                "for ever until you stop it).<br><br>" +
                                "Do you want to continue anyway?" +
                                "</body></html>",
                                GenerateDialog.this.getTitle(),
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        if (result != JOptionPane.YES_OPTION)
                            return;
                    }
                    generate();
                } else
                    stop();
            }
        });
        pnlGenerate.add(btnGenerate);
        btnNext = new JButton();
        btnNext.setText(">");
        btnNext.setEnabled(false);
        btnNext.setMnemonic(KeyEvent.VK_RIGHT);
        btnNext.setToolTipText("Restore the next Sudoku");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                next();
            }
        });
        pnlGenerate.add(btnNext);

        JButton btnClose = new JButton();
        btnClose.setText("Close");
        btnClose.setMnemonic(KeyEvent.VK_C);
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        pnlClose.add(btnClose);

        // Parameters pane
        paramPanel.setLayout(new BoxLayout(paramPanel, BoxLayout.Y_AXIS));
        JPanel symmetryPanel = new JPanel();
        symmetryPanel.setBorder(new TitledBorder("Allowed symmetry types"));
        paramPanel.add(symmetryPanel);
        JPanel difficultyPanel = new JPanel();
        difficultyPanel.setBorder(new TitledBorder("Difficulty"));
        paramPanel.add(difficultyPanel);

        // Parameters - Symmetry pane
        symmetryPanel.setLayout(new GridLayout(3, 4));
        for (final Symmetry symmetry : Symmetry.values()) {
            final JCheckBox chkSymmetry = new JCheckBox();
            chkSymmetry.setSelected(symmetries.contains(symmetry));
            chkSymmetry.setText(symmetry.toString());
            chkSymmetry.setToolTipText(symmetry.getDescription());
            chkSymmetry.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (chkSymmetry.isSelected()) {
                        symmetries.add(symmetry);
                    } else {
                        symmetries.remove(symmetry);
                    }
                }
            });
            symmetryPanel.add(chkSymmetry);
        }

        // Parameters - Difficulty
        difficultyPanel.setLayout(new BorderLayout());
        JPanel diffChooserPanel = new JPanel();
        diffChooserPanel.setLayout(new BoxLayout(diffChooserPanel, BoxLayout.X_AXIS));
        difficultyPanel.add(diffChooserPanel, BorderLayout.NORTH);
        final JComboBox<Difficulty> selDifficulty = new JComboBox<>();
        for (Difficulty d : Difficulty.values()) {
            selDifficulty.addItem(d);
        }
        selDifficulty.setToolTipText("Choose the difficulty of the Sudoku to generate");
        selDifficulty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                difficulty = (Difficulty)selDifficulty.getSelectedItem();
                lblDifficulty.setText(difficulty.getHtmlDescription());
            }
        });
        diffChooserPanel.add(selDifficulty);
        final JRadioButton chkExactDifficulty = new JRadioButton("Exact difficulty");
        chkExactDifficulty.setToolTipText("Generate a Sudoku with exactly the chosen difficulty");
        chkExactDifficulty.setMnemonic(KeyEvent.VK_E);
        chkExactDifficulty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chkExactDifficulty.isSelected())
                    isExact = true;
            }
        });
        diffChooserPanel.add(chkExactDifficulty);
        final JRadioButton chkMaximumDifficulty = new JRadioButton("Maximum difficulty");
        chkMaximumDifficulty.setToolTipText("Generate a Sudoku with at most the chosen difficulty");
        chkMaximumDifficulty.setMnemonic(KeyEvent.VK_M);
        chkMaximumDifficulty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chkMaximumDifficulty.isSelected())
                    isExact = false;
            }
        });
        diffChooserPanel.add(chkMaximumDifficulty);
        ButtonGroup group = new ButtonGroup();
        group.add(chkExactDifficulty);
        group.add(chkMaximumDifficulty);
        chkExactDifficulty.setSelected(true);

        JPanel pnlDifficulty = new JPanel();
        pnlDifficulty.setLayout(new BorderLayout());
        pnlDifficulty.setBorder(new TitledBorder("Description"));
        difficultyPanel.add(pnlDifficulty, BorderLayout.CENTER);
        lblDifficulty = new JLabel();
        lblDifficulty.setText("<html><body><b>W</b><br>W<br>W</body></html>");
        lblDifficulty.setToolTipText("Explanations of the chosen difficulty");
        pnlDifficulty.add(lblDifficulty, BorderLayout.NORTH);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                lblDifficulty.setText(difficulty.getHtmlDescription());
            }
        });

        // Parameters - Warning label
        JPanel warningPanel = new JPanel();
        warningPanel.setBorder(new TitledBorder("Warning"));
        paramPanel.add(warningPanel);
        JLabel lblWarning = new JLabel();
        warningPanel.add(lblWarning);
        lblWarning.setText("<html><body>Depending on the chosen parameters, it may " +
        "take from<br>a few seconds to some minutes to generate a new Sudoku.</body></html>");

        // Parameters - options
        JPanel optionPanel = new JPanel();
        optionPanel.setBorder(new TitledBorder(""));
        optionPanel.setLayout(new GridLayout(1, 1));
        paramPanel.add(optionPanel, BorderLayout.NORTH);
        chkAnalysis = new JCheckBox("Show the analysis of the generated Sudoku");
        chkAnalysis.setToolTipText("Display the difficulty rating of the Sudoku and the " +
        "techniques that are necessary to solve it in the main window");
        chkAnalysis.setMnemonic(KeyEvent.VK_A);
        chkAnalysis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshSudokuPanel();
            }
        });
        optionPanel.add(chkAnalysis);

    // Multiple generation / export UI

    JPanel exportPanel = new JPanel();
    exportPanel.setLayout(new BoxLayout(exportPanel, BoxLayout.Y_AXIS));
    exportPanel.setBorder(new TitledBorder("Output / Batch"));
    optionPanel.add(exportPanel);

    // First row: Count and Save to file
    JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
    row1.add(new JLabel("Count:"));
    spinnerCount = new JSpinner(new SpinnerNumberModel(1, 1, 10000, 1));
    spinnerCount.setToolTipText("Number of Sudokus to generate");
    row1.add(spinnerCount);
    chkSaveToFile = new JCheckBox("Save to file");
    chkSaveToFile.setToolTipText("Save generated Sudokus into a file (one per line)");
    row1.add(chkSaveToFile);
    exportPanel.add(row1);

    // Second row: Output file and browse
    JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
    txtOutFile = new JTextField(15); // Reduced from 30 to 15 columns
    txtOutFile.setEnabled(false);
    row2.add(txtOutFile);
    btnBrowseOut = new JButton("Browse...");
    btnBrowseOut.setEnabled(false);
    btnBrowseOut.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser();
            int res = fc.showSaveDialog(GenerateDialog.this);
            if (res == JFileChooser.APPROVE_OPTION) {
                txtOutFile.setText(fc.getSelectedFile().getAbsolutePath());
            }
        }
    });
    row2.add(btnBrowseOut);
    exportPanel.add(row2);

    // Third row: Format selection
    JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
    row3.add(new JLabel("Format:"));
    comboFormat = new JComboBox<>(new String[] {"Classique", "SER"});
    comboFormat.setSelectedItem(selectedFormat);
    comboFormat.setToolTipText("Choisissez le format de sortie : Classique ou SER");
    comboFormat.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            selectedFormat = (String) comboFormat.getSelectedItem();
        }
    });
    row3.add(comboFormat);
    exportPanel.add(row3);

    // Progress bar (remains below exportPanel)
    progressBar = new JProgressBar();
    progressBar.setStringPainted(true);
    progressBar.setVisible(false);
    progressBar.setMaximumSize(new Dimension(350, 20));
    progressBar.setPreferredSize(new Dimension(350, 20));
    progressBar.setMinimumSize(new Dimension(100, 20));
    JPanel progressPanel = new JPanel();
    progressPanel.setLayout(new BoxLayout(progressPanel, BoxLayout.X_AXIS));
    progressPanel.add(progressBar);
    optionPanel.add(progressPanel);

        chkSaveToFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean sel = chkSaveToFile.isSelected();
                txtOutFile.setEnabled(sel);
                btnBrowseOut.setEnabled(sel);
                comboFormat.setEnabled(sel);
            }
        });
        comboFormat.setEnabled(false);

    }

    private void generate() {
        if (symmetries.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select at least one symmetry",
                    "Generate", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Gather parameters
        double minDifficulty = difficulty.getMinDifficulty();
        double maxDifficulty = difficulty.getMaxDifficulty();
		double includeDifficulty1 = difficulty.getincludeDifficulty1();
		double includeDifficulty2 = difficulty.getincludeDifficulty2();
		double includeDifficulty3 = difficulty.getincludeDifficulty3();
		double excludeDifficulty1 = difficulty.getexcludeDifficulty1();
		double excludeDifficulty2 = difficulty.getexcludeDifficulty2();
		double excludeDifficulty3 = difficulty.getexcludeDifficulty3();
		double notMaxDifficulty1 = difficulty.getnotMaxDifficulty1();
		double notMaxDifficulty2 = difficulty.getnotMaxDifficulty2();
		double notMaxDifficulty3 = difficulty.getnotMaxDifficulty3();
		String excludeTechnique1 = difficulty.getexcludeTechnique1();
		String excludeTechnique2 = difficulty.getexcludeTechnique2();
		String excludeTechnique3 = difficulty.getexcludeTechnique3();
		String includeTechnique1 = difficulty.getincludeTechnique1();
		String includeTechnique2 = difficulty.getincludeTechnique2();
		String includeTechnique3 = difficulty.getincludeTechnique3();
		String notMaxTechnique1 = difficulty.getnotMaxTechnique1();
		String notMaxTechnique2 = difficulty.getnotMaxTechnique2();
		String notMaxTechnique3 = difficulty.getnotMaxTechnique3();
		String getOneOfThree_1 = difficulty.getOneOfThree_1();
		String getOneOfThree_2 = difficulty.getOneOfThree_2();
		String getOneOfThree_3 = difficulty.getOneOfThree_3();
        if (!isExact)
            minDifficulty = 1.0;
        List<Symmetry> symList = new ArrayList<Symmetry>(symmetries);

        // Generate grid (possibly multiple and export)
        int count = 1;
        boolean saveToFile = false;
        String outPath = null;
        try {
            if (spinnerCount != null) count = ((Number)spinnerCount.getValue()).intValue();
        } catch (Exception ex) { count = 1; }
        if (chkSaveToFile != null && chkSaveToFile.isSelected()) {
            saveToFile = true;
            outPath = txtOutFile.getText().trim();
            if (outPath.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please choose an output file before saving.", "Generate", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        // Pass new parameters count / saveToFile / outPath to GeneratorThread
        generator = new GeneratorThread(symList, minDifficulty, maxDifficulty, includeDifficulty1, includeDifficulty2, includeDifficulty3, excludeDifficulty1, excludeDifficulty2, excludeDifficulty3, notMaxDifficulty1, notMaxDifficulty2, notMaxDifficulty3, excludeTechnique1, excludeTechnique2, excludeTechnique3, includeTechnique1, includeTechnique2, includeTechnique3, notMaxTechnique1, notMaxTechnique2, notMaxTechnique3, getOneOfThree_1, getOneOfThree_2, getOneOfThree_3, count, saveToFile, outPath);
        generator.start();
    }

    /**
     * Thread that generates a mew grid.
     */
    private class GeneratorThread extends Thread {

        private final List<Symmetry> symmetries;
        private final double minDifficulty;
        private final double maxDifficulty;
		private final double includeDifficulty1;
		private final double includeDifficulty2;
		private final double includeDifficulty3;
		private final double excludeDifficulty1;
		private final double excludeDifficulty2;
		private final double excludeDifficulty3;
		private final double notMaxDifficulty1;
		private final double notMaxDifficulty2;
		private final double notMaxDifficulty3;
		private final String excludeTechnique1;
		private final String excludeTechnique2;
		private final String excludeTechnique3;
		private final String includeTechnique1;
		private final String includeTechnique2;
		private final String includeTechnique3;
		private final String notMaxTechnique1;
		private final String notMaxTechnique2;
		private final String notMaxTechnique3;
		private final String getOneOfThree_1;
 		private final String getOneOfThree_2;
		private final String getOneOfThree_3;
      private Generator generator;
      private final int count;
      private final boolean saveToFile;
      private final String outPath;

      public GeneratorThread(List<Symmetry> symmetries, double minDifficulty, double maxDifficulty, double includeDifficulty1, double includeDifficulty2, double includeDifficulty3, double excludeDifficulty1, double excludeDifficulty2, double excludeDifficulty3, double notMaxDifficulty1, double notMaxDifficulty2, double notMaxDifficulty3, String excludeTechnique1, String excludeTechnique2, String excludeTechnique3, String includeTechnique1, String includeTechnique2, String includeTechnique3, String notMaxTechnique1, String notMaxTechnique2, String notMaxTechnique3, String getOneOfThree_1, String getOneOfThree_2, String getOneOfThree_3, int count, boolean saveToFile, String outPath) {
            this.symmetries = symmetries;
            this.minDifficulty = minDifficulty;
            this.maxDifficulty = maxDifficulty;
			this.includeDifficulty1 = includeDifficulty1;
 			this.includeDifficulty2 = includeDifficulty2;
			this.includeDifficulty3 = includeDifficulty3;
			this.excludeDifficulty1 = excludeDifficulty1;
 			this.excludeDifficulty2 = excludeDifficulty2;
			this.excludeDifficulty3 = excludeDifficulty3;
			this.notMaxDifficulty1 = notMaxDifficulty1;
 			this.notMaxDifficulty2 = notMaxDifficulty2;
			this.notMaxDifficulty3 = notMaxDifficulty3;
			this.excludeTechnique1 = excludeTechnique1;
			this.excludeTechnique2 = excludeTechnique2;
			this.excludeTechnique3 = excludeTechnique3;
			this.includeTechnique1 = includeTechnique1;
			this.includeTechnique2 = includeTechnique2;
			this.includeTechnique3 = includeTechnique3;
			this.notMaxTechnique1 = notMaxTechnique1;
			this.notMaxTechnique2 = notMaxTechnique2;
			this.notMaxTechnique3 = notMaxTechnique3;
			this.getOneOfThree_1 = getOneOfThree_1;
			this.getOneOfThree_2 = getOneOfThree_2;
            this.getOneOfThree_3 = getOneOfThree_3;
            this.count = Math.max(1, count);
            this.saveToFile = saveToFile;
            this.outPath = outPath;
        }

        @Override
        public void interrupt() {
            generator.interrupt();
        }

        @Override
        public void run() {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    engine.setGrid(new Grid());
                    AutoBusy.setBusy(GenerateDialog.this, true);
                    AutoBusy.setBusy(btnGenerate, false);
                    btnGenerate.setText("Stop");
                }
            });
            BufferedWriter writer = null;
            try {
                if (saveToFile) {
                    writer = new BufferedWriter(new FileWriter(outPath, true));
                }
                // Affiche et initialise la barre de progression
                SwingUtilities.invokeLater(() -> {
                    progressBar.setMinimum(0);
                    progressBar.setMaximum(count);
                    progressBar.setValue(0);
                    progressBar.setString("0 / " + count);
                    progressBar.setVisible(true);
                });
                for (int i = 0; i < count; i++) {
                    if (Thread.currentThread().isInterrupted()) break;
                    generator = new Generator();
                    final Grid result = generator.generate(symmetries, minDifficulty, maxDifficulty, includeDifficulty1, includeDifficulty2, includeDifficulty3, excludeDifficulty1, excludeDifficulty2, excludeDifficulty3, notMaxDifficulty1, notMaxDifficulty2, notMaxDifficulty3, excludeTechnique1, excludeTechnique2, excludeTechnique3, includeTechnique1, includeTechnique2, includeTechnique3, notMaxTechnique1, notMaxTechnique2, notMaxTechnique3, getOneOfThree_1, getOneOfThree_2, getOneOfThree_3);
                    if (result != null) {
                        // Add to list and update UI
                        synchronized (sudokuList) {
                            sudokuList.add(result);
                            sudokuIndex = sudokuList.size() - 1;
                        }
                        SwingUtilities.invokeLater(() -> {
                            refreshSudokuPanel();
                            progressBar.setValue(progressBar.getValue() + 1);
                            progressBar.setString(progressBar.getValue() + " / " + count);
                        });
                        // Write to file in selected format
                        if (writer != null) {
                            if (selectedFormat.equals("SER")) {
                                // Format SER: grille + rating (ex: "%g ED=%r/%p/%d")
                                String grille = result.toString81();
                                double rating = 0.0, pearl = 0.0, diamond = 0.0;
                                try {
                                    Solver solver = new Solver(result);
                                    // Formatter bidon, pas d'écriture fichier
                                    diuf.sudoku.test.serate.Formatter dummyFormatter = new diuf.sudoku.test.serate.Formatter(new java.io.PrintWriter(new java.io.StringWriter()), "", "", "", "");
                                    solver.getDifficulty(dummyFormatter);
                                    rating = solver.difficulty;
                                    pearl = solver.pearl;
                                    diamond = solver.diamond;
                                } catch (Exception ex) {}
                                String ratingStr = String.format("%.1f", rating);
                                writer.write(grille + " " + ratingStr);
                                writer.newLine();
                                writer.flush();
                            } else {
                                // Classique : 81 caractères
                                StringBuilder sb = new StringBuilder(81);
                                for (int y = 0; y < 9; y++) {
                                    for (int x = 0; x < 9; x++) {
                                        int v = result.getCellValue(x, y);
                                        if (v <= 0) sb.append('.'); else sb.append((char)('0' + v));
                                    }
                                }
                                writer.write(sb.toString());
                                writer.newLine();
                                writer.flush();
                            }
                        }
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (writer != null) {
                    try { writer.close(); } catch (IOException e) { /* ignore */ }
                }
                SwingUtilities.invokeLater(() -> {
                    progressBar.setVisible(false);
                    if (GenerateDialog.this.isVisible()) {
                        AutoBusy.setBusy(GenerateDialog.this, false);
                        btnGenerate.setText("Generate");
                    }
                });
            }
            GenerateDialog.this.generator = null;
        }

    }

    private void stop() {
        if (generator != null && generator.isAlive()) {
            generator.interrupt();
            try {
                generator.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        generator = null;
        refreshSudokuPanel();
    }

    private void next() {
        if (sudokuIndex < sudokuList.size() - 1) {
            sudokuIndex += 1;
            refreshSudokuPanel();
        }
    }

    private void prev() {
        if (sudokuIndex > 0) {
            sudokuIndex -= 1;
            refreshSudokuPanel();
        }
    }

    private void refreshSudokuPanel() {
        Grid sudoku = sudokuList.get(sudokuIndex);
        engine.setGrid(sudoku);
        btnPrev.setEnabled(sudokuIndex > 0);
        btnNext.setEnabled(sudokuIndex < sudokuList.size() - 1);

        if (chkAnalysis.isSelected()) {
            // Display analysis of the Sudoku
            Hint analysis = sudokuAnalyses.get(sudoku);
            if (analysis == null) {
                analysis = engine.analyse();
                sudokuAnalyses.put(sudoku, analysis);
            } else {
                engine.showHint(analysis);
            }
        }
    }

    private void close() {
        stop();
        super.setVisible(false);
        super.dispose();
    }

}
