using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Assignment9.Controllers
{
    public class SponsorsController : Controller
    {
        private Manager m = new Manager();
        // GET: Sponsors
        public ActionResult Index()
        {
            return View(m.SponsorGetAll());
        }

        // GET: Sponsors/Details/5
        [Authorize(Roles = "Admin, Staff")]
        public ActionResult Details(int id)
        {
            ViewBag.sId = id;
            return View(m.SponsorGetByIdWithDetail(id));
        }

        // GET: Sponsors/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Sponsors/Create
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

        // GET: Sponsors/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Sponsors/Edit/5
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

        // GET: Sponsors/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Sponsors/Delete/5
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
