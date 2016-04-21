using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Assignment9.Controllers
{
    public class LOLTeamsController : Controller
    {
        private Manager m = new Manager();

        // GET: LOLTeams
        public ActionResult Index()
        {
            return View(m.LOLTeamGetAll());
        }

        // GET: LOLTeams/Details/5
        [Authorize(Roles = "Admin, Manager")]
        public ActionResult Details(int id)
        {
            return View(m.LOLTeamGetByIdWithDetail(id));
        }

        // GET: LOLTeams/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: LOLTeams/Create
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

        // GET: LOLTeams/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: LOLTeams/Edit/5
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

        // GET: LOLTeams/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: LOLTeams/Delete/5
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
