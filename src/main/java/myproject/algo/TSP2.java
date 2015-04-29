package myproject.algo;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Scrollbar;

public class TSP2 extends Applet implements Runnable {

	public int NCITY = 5;
	public int NGEONEURON;
	public static final double COUNTRY = 1.00;
	public static final double NEAR = 0.05;

	public static final Color bkC = new Color(0x000090);
	public static final Color bk2C = new Color(0x000050);
	public static final Color lnC = new Color(0xff0000);
	public static final Color ln2C = new Color(0xcccc00);
	public static final Color fgC = new Color(0xffffff);

	public Image homeI, offscreen;
	public int imagewidth, imageheight;
	public Thread animator = null;
	public boolean please_stop = false;
	Font mF = new Font("Courier", Font.BOLD, 12);
	Font sF = new Font("Courier", Font.BOLD, 8);
	public int counter;

	public City city[];
	public GeoNeuron gn[];

	public double r[][];

	public double theta, phi, momentum;

	public Scrollbar cscroll;

	// /////////////////////////////////////////////////////////////////
	//
	// Init section
	//
	// /////////////////////////////////////////////////////////////////

	public void kohonenInit() {
		theta = 0.5;
		phi = 0.5;
		momentum = 0.995;

		NCITY = cscroll.getValue() / 10;
		NGEONEURON = NCITY * 2;

		// URL url;
		// homeI = this.getImage(this.getDocumentBase(), "home.gif");

		city = new City[NCITY];
		for (int i = 0; i < NCITY; i++)
			city[i] = new City(Math.random() * COUNTRY, Math.random() * COUNTRY);

		double alpha = 0.0;
		gn = new GeoNeuron[NGEONEURON];
		for (int i = 0; i < NGEONEURON; i++) {
			gn[i] = new GeoNeuron(0.5 + 0.5 * Math.cos(alpha),
					0.5 + 0.5 * Math.sin(alpha));
			alpha += Math.PI * 2.0 / (double) (NGEONEURON);
		}

		r = new double[NGEONEURON][NGEONEURON];

		makeR(theta);

		counter = 0;

	}

	// /////////////////////////////////////////////////////////////////
	//
	// Problem section
	//
	// /////////////////////////////////////////////////////////////////

	public void makeR(double th) {
		// System.out.println("");
		for (int i = 0; i < NGEONEURON; i++) {
			r[i][i] = 1.0;
			for (int j = i + 1; j < NGEONEURON; j++) {
				r[i][j] = Math.exp(-1.0
						* (gn[i].dist(gn[j]) * gn[i].dist(gn[j]))
						/ (2.0 * th * th));
				r[j][i] = r[i][j];
				// System.out.print(" "+r[i][j]);
			}
			// System.out.println("");
		}
	}

	// The body of the animator thread.
	public void run() {
		int idx, j;
		double x1, x2, mindist;
		int count = 0;
		while (!please_stop) {

			counter++;

			// CHOSE A RANDOM PATTERN
			idx = (int) (Math.random() * NCITY);
			x1 = city[idx].x + (Math.random() * NEAR) - NEAR / 2;
			x2 = city[idx].y + (Math.random() * NEAR) - NEAR / 2;
			city[idx].choose++;

			// SEARCH FOR MINIMAL
			mindist = 100000.0;
			j = -1;
			for (int i = 0; i < NGEONEURON; i++) {
				double d = (x1 - gn[i].wx) * (x1 - gn[i].wx) + (x2 - gn[i].wy)
						* (x2 - gn[i].wy);
				// double d = x1*gn[i].wx + x2*gn[i].wy;
				// System.out.println("d="+d);
				if (d < mindist) {
					mindist = d;
					j = i;
				}
			}

			gn[j].update++;

			// UPDATE WEIGHTS
			for (int i = 0; i < NGEONEURON; i++) {
				gn[i].wx += (phi * r[i][j] * (x1 - gn[i].wx));
				gn[i].wy += (phi * r[i][j] * (x2 - gn[i].wy));
			}

			// DECREASE LEARNING PARAMETERS
			phi *= momentum;
			theta *= momentum;

			// RE-COMPUTE r MATRIX
			makeR(theta);

			// PLOT RESULT EVERY 10 SESSIONS
			count = (count++) % 10;

			if (count == 0) {
				// System.out.println("theta = "+theta+"  phi = "+phi);

				paint(this.getGraphics());

				// Call Garbage Collect
				// System.gc();

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				;
			}
		}
		animator = null;
	}

	// /////////////////////////////////////////////////////////////////
	//
	// Functional section
	//
	// /////////////////////////////////////////////////////////////////

	public void init() {

		cscroll = new Scrollbar(Scrollbar.HORIZONTAL, NCITY * 10, 10, 30, 200);
		cscroll.setLineIncrement(10);
		cscroll.setPageIncrement(10);
		add(cscroll);

		kohonenInit();
	}

	private int toXReal(double val) {
		int w = this.size().width;
		return (int) (val * ((double) w / 2.0 - 50.0) / COUNTRY + 25.0);
	}

	private int toYReal(double val) {
		int h = this.size().height;
		return (int) (val * ((double) h - 50.0) / COUNTRY + 25.0);
	}

	private int to2XReal(double val) {
		int w = this.size().width;
		return (int) ((double) w / 2.0 + val * ((double) w / 2.0 - 50.0)
				/ COUNTRY + 25.0);
	}

	private int to2YReal(double val) {
		int h = this.size().height;
		return (int) (val * ((double) h - 50.0) / COUNTRY + 25.0);
	}

	public void paintLeft(Graphics g) {
		Dimension size = this.size();
		int w = size.width, h = size.height;

		g.setFont(mF);

		// CLEAR ALL
		g.setColor(bkC);
		g.fillRect(0, 0, w, h);
		// DRAW GRID
		g.setColor(bk2C);
		for (double i = 0; i <= COUNTRY; i += (COUNTRY / 20.0)) {
			g.drawLine(toXReal(0.0), toYReal(i), toXReal(COUNTRY), toYReal(i));
			g.drawLine(toXReal(i), toYReal(0.0), toXReal(i), toYReal(COUNTRY));
		}

		// DRAW PATH
		g.setColor(lnC);
		for (int i = 0; i < NGEONEURON; i++) {
			g.drawLine(toXReal(gn[i].wx), toYReal(gn[i].wy), toXReal(gn[(i + 1)
					% NGEONEURON].wx), toYReal(gn[(i + 1) % NGEONEURON].wy));
			g.drawString("" + i + "-" + (gn[i].update * 100 / counter) + "%",
					toXReal(gn[i].wx), toYReal(gn[i].wy));
		}

		g.setColor(fgC);

		// DRAW CITYS
		for (int i = 0; i < NCITY; i++) {
			g.drawOval(toXReal(city[i].x) - 4, toYReal(city[i].y) - 4, 8, 8);
			g.drawString("" + i + "-" + (city[i].choose * 100 / counter) + "%",
					toXReal(city[i].x), toYReal(city[i].y) + 8);
		}
	}

	public void paintRight(Graphics g) {
		Dimension size = this.size();
		int w = size.width, h = size.height;

		// CLEAR ALL
		g.setColor(bkC);
		g.fillRect(0, 0, w, h);

		g.setFont(sF);

		// DRAW CITYS
		g.setColor(fgC);
		for (int i = 0; i < NCITY; i++) {
			g.drawOval(to2XReal(city[i].x) - 4, to2YReal(city[i].y) - 4, 8, 8);
			// g.drawString("["+city[i].wx+";"+gn[i].wy+"]",to2XReal(gn[i].x),to2YReal(gn[i].y));
		}

		g.setColor(ln2C);
		for (int i = 0; i < NGEONEURON; i++)
			for (int j = i + 1; j < NGEONEURON; j++) {
				g.drawLine(to2XReal(gn[i].x), to2YReal(gn[i].y),
						to2XReal(gn[j].x), to2YReal(gn[j].y));
				g.drawString("" + r[i][j], to2XReal((gn[i].x + gn[j].x) / 2),
						to2YReal((gn[i].y + gn[j].y) / 2));
				// r[i][j] = Math.exp( -1.0 * (double)(
				// gn[i].dist(gn[j])*gn[i].dist(gn[j]) )/(2.0*th));

			}
		g.setFont(mF);
		g.setColor(fgC);
		g.drawString("phi=" + phi + " theta=" + theta, to2XReal(0.0),
				to2YReal(0.0) + 20);
	}

	public void paint(Graphics g) {
		Dimension size = this.size();
		int w = size.width, h = size.height;

		this.setBackground(bkC);

		if ((offscreen == null) || ((imagewidth != w) || (imageheight != h))) {
			offscreen = this.createImage(w, h);
			imagewidth = w;
			imageheight = h;
		}

		Rectangle clip = new Rectangle(toXReal(0), toYReal(0),
				toXReal(COUNTRY), toYReal(COUNTRY));

		Graphics goff = offscreen.getGraphics();
		goff.clipRect(clip.x, clip.y, clip.width, clip.height);
		Graphics g1 = this.getGraphics();
		g1.clipRect(clip.x, clip.y, clip.width, clip.height);

		paintLeft(goff);
		g1.drawImage(offscreen, 0, 0, this);

		// clip = new
		// Rectangle(to2XReal(0),to2YReal(0),to2XReal(COUNTRY),to2YReal(COUNTRY));

		// goff = offscreen.getGraphics();
		// goff.clipRect(clip.x, clip.y, clip.width, clip.height);
		// g1 = this.getGraphics();
		// g1.clipRect(clip.x, clip.y, clip.width, clip.height);

		// paintRight(goff);
		// g1.drawImage(offscreen, 0, 0, this);

		clip = null;
		goff = null;
		g1 = null;
		System.gc();

		// CLEAR ALL
		g.setColor(bkC);
		g.fillRect(w / 2 + 30, 0, w / 2 + 130, 20);
		g.setColor(fgC);

		g.drawString("# of city:" + cscroll.getValue() / 10, w / 2 + 30, 20);

	}

	// Start the animation
	public void start() {
		animator = new Thread(this);

		animator.start();

	}

	// Stop it.
	public void stop() {
		if (animator != null)
			animator.stop();
		animator = null;
	}

	// Stop and start animating on mouse clicks.
	public boolean mouseDown(Event e, int x, int y) {
		// if running, stop it. Otherwise, start it.
		if (animator != null) {
			please_stop = true;
		} else {
			please_stop = false;
			animator = new Thread(this);

			kohonenInit();
			animator.start();
		}
		return true;
	}

}