using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Assignment9.Controllers
{
    public class LOLPlayersController : Controller
    {
        private Manager m = new Manager();
        // GET: LOLPlayers
        public ActionResult Index()
        {
            return View(m.LOLPLayerGetAll());
        }

        // GET: LOLPlayers/Details/5
        [Authorize(Roles = "Admin, Coach")]
        public ActionResult Details(int id)
        {
            return View(m.LOLPlayerGetByIdWithDetail(id));
        }

        // GET: LOLPlayers/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: LOLPlayers/Create
        [HttpPost]
        public ActionResult Create(FormCollection collection)
        {
            try
            {
                // TODO: Add insert logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: LOLPlayers/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: LOLPlayers/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: LOLPlayers/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: LOLPlayers/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
